package com.scouter.silentsdelight.events;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;
import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.player.VibrationEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = SilentsDelight.MODID, value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {
    final static Minecraft minecraft = Minecraft.getInstance();
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void playSound(TickEvent.ClientTickEvent event) {
        if(event.phase == TickEvent.Phase.END) return;

        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;
        if (level == null)
            return;

        Player player = minecraft.player;
        UUID uuid = player.getUUID();
        Collection<Integer> ids = VibrationEntities.getToShow(uuid);

        for(Integer id : ids) {
            Entity entity = level.getEntity(id);
            if(entity == null) continue;
            BlockState state = entity.getBlockStateOn();
            if(state.is(Blocks.AIR)) continue;
            SoundEvent event1 = state.getSoundType().getStepSound();
            level.playLocalSound(entity.blockPosition(), event1, SoundSource.AMBIENT, 10F, 1F, false);
        }
    }

    @SubscribeEvent
    public static void renderLevelStage(RenderLevelStageEvent event) {
        if(event.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES) {

            Minecraft minecraft = Minecraft.getInstance();
            ClientLevel level = minecraft.level;
            if (level == null)
                return;


            PoseStack poseStack = event.getPoseStack();

            Player player = minecraft.player;
            if (player == null || player.isSpectator())
                return;

            UUID uuid = player.getUUID();
            Vec3 projectedView = minecraft.gameRenderer.getMainCamera().getPosition();
            Collection<Integer> ids = VibrationEntities.getToShow(uuid);
            RenderBuffers renderBuffers = minecraft.renderBuffers();
            MultiBufferSource.BufferSource bufferSource = renderBuffers.bufferSource();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            GL11.glDisable(GL11.GL_DEPTH_TEST);

            poseStack.pushPose();
            poseStack.translate(-projectedView.x, -projectedView.y, -projectedView.z);
            RenderSystem.enableDepthTest();
            RenderSystem.depthFunc(514);



            List<Integer> toRemove = new ArrayList<>();
            for(Integer id : ids) {
                Entity entity = level.getEntity(id);
                if(entity == null) continue;
                int time = VibrationEntities.getTime(id);


                float multp = 1 - (time/50F);
                final RenderType renderType = RenderType.lines();
                VertexConsumer builder = bufferSource.getBuffer(renderType);

                if(time > 40) {
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() + 0.004), (float) entity.position().z, 0.5F, 0x56a9d4);
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() - 1), (float) entity.position().z, 0.25F, 0x56a9d4);
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() - 2), (float) entity.position().z, 0.125F, 0x56a9d4);
                } else if(time > 25) {
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() + 0.004), (float) entity.position().z, 1F, 0x56a9d4);
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() - 1 ), (float) entity.position().z, 0.5F, 0x56a9d4);
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() - 2), (float) entity.position().z, 0.25F, 0x56a9d4);
                } else {
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() + 0.004), (float) entity.position().z, 1.5F, 0x56a9d4);
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() - 1), (float) entity.position().z, 1F, 0x56a9d4);
                    drawCircle(builder, poseStack, (float) entity.position().x, (int) (entity.position().y() - 2), (float) entity.position().z, 0.5F, 0x56a9d4);
                }
                bufferSource.endBatch(renderType);

                //outlinebuffersource.endOutlineBatch();
                toRemove.add(id);
            }

            VibrationEntities.remove(uuid, toRemove);
            RenderSystem.disableDepthTest();
            poseStack.popPose();



            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
        }
    }

    public static void drawCircle(VertexConsumer bufferBuilder, PoseStack matrixStack, float centerX, int y, float centerZ, float radius, int color) {
        color = fixAlpha(color);
        Matrix4f matrix = matrixStack.last().pose();
        float numPoints = 360F;
        float angleIncrement = Mth.TWO_PI / numPoints;
        float a = (float) (color >> 24 & 255) / 255.0F;
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;

        for (int i = 1; i <= numPoints; i++) {
            float angle = angleIncrement * i;
            float xd = (float) (radius * Math.sin(angle));
            float zd = (float) (radius * Math.cos(angle));

            bufferBuilder.vertex(matrix, centerX + xd, y, centerZ+ zd).color(r, g, b, a).normal(matrixStack.last().normal(), 0, 1, 0).endVertex();
        }
    }

    public static int fixAlpha(int color) {
        return (color & 0xFF000000) == 0 ? color | 0xFF000000 : color;
    }
}
