package com.scouter.silentsdelight.setup;

import com.scouter.silentsdelight.message.EntityRenderOutlineMessage;
import com.scouter.silentsdelight.player.VibrationEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;
import java.util.UUID;

public class ClientSetup implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        RenderLayerRegistration();

        ClientTickEvents.START_CLIENT_TICK.register((e) -> {
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
        });
    }


    public static void RenderLayerRegistration(){
        RenderType cutoutMipped = RenderType.cutoutMipped();
        RenderType cutout = RenderType.cutout();
        RenderType translucent = RenderType.translucent();
        RenderType translucentnocrumb = RenderType.translucentNoCrumbling();
        RenderType solid = RenderType.solid();


    }
    public static void init(){
        ClientPlayNetworking.registerGlobalReceiver(EntityRenderOutlineMessage.ID, ((client, handler, buf, responseSender) -> {
            UUID sender = buf.readUUID();
            int entityId = buf.readVarInt();
            VibrationEntities.addToShow(sender, entityId);
        }));
    }
}
