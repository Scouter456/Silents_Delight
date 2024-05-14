package com.scouter.silentsdelight.player;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.effects.SDEffects;
import com.scouter.silentsdelight.message.EntityRenderOutlineMessage;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class PlayerVibration implements VibrationSystem {

    private final Data data;
    private final User user;
    public PlayerVibration(ServerPlayer serverPlayer) {
         data = new Data();
         user = new VibrationUser(serverPlayer);

    }

    @Override
    public Data getVibrationData() {
        return data;
    }

    @Override
    public User getVibrationUser() {
        return user;
    }



    public static class VibrationUser implements User {

        private final UUID owner;
        private final Level level;
        private final PositionSource positionSource;
        private final ServerPlayer serverPlayer;
        public VibrationUser(ServerPlayer entity) {
            this.owner = entity.getUUID();
            this.level = entity.level();
            positionSource = new EntityPositionSource(entity, entity.getEyeHeight());
            this.serverPlayer = entity;
        }

        @Override
        public int getListenerRadius() {
            return 12;
        }

        @Override
        public TagKey<GameEvent> getListenableEvents() {
            return GameEventTags.WARDEN_CAN_LISTEN;
        }

        @Override
        public PositionSource getPositionSource() {
            return positionSource;
        }

        @Override
        public boolean canReceiveVibration(ServerLevel pLevel, BlockPos pPos, GameEvent pGameEvent, GameEvent.Context pContext) {
            if(!serverPlayer.hasEffect(SDEffects.WARDENS_SENSE)) {
                return false;
            }
            if(pContext.sourceEntity() instanceof ServerPlayer serverPlayer) {
               return !serverPlayer.is(serverPlayer);
            }


            if(pContext.sourceEntity() instanceof TamableAnimal animal) {
                return !animal.hasPassenger((e) -> true);
            }

            return true;
        }



        @Override
        public void onReceiveVibration(ServerLevel pLevel, BlockPos pPos, GameEvent pGameEvent, @Nullable Entity pEntity, @Nullable Entity pPlayerEntity, float pDistance) {
            //get gamedata and put entity in it to do stuff with it
            if(pEntity != null) {
                ServerPlayNetworking.send(serverPlayer, EntityRenderOutlineMessage.ID, EntityRenderOutlineMessage.write(serverPlayer.getUUID(), pEntity.getId()));
            }

            if(pPlayerEntity != null) {
                ServerPlayNetworking.send(serverPlayer, EntityRenderOutlineMessage.ID, EntityRenderOutlineMessage.write(serverPlayer.getUUID(), pPlayerEntity.getId()));
            }

        }
    }
}
