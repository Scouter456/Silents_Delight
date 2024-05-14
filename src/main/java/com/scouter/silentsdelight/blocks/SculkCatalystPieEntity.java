package com.scouter.silentsdelight.blocks;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.advancements.SDCriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SculkCatalystBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.BlockPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.phys.Vec3;

public class SculkCatalystPieEntity extends BlockEntity implements GameEventListener.Holder<SculkCatalystPieEntity.CatalystListener>{
    private final SculkCatalystPieEntity.CatalystListener catalystListener;
    public SculkCatalystPieEntity(BlockPos pPos, BlockState pBlockState) {
        super(SDBlockEntities.CATALYST_PIE.get(), pPos, pBlockState);
        this.catalystListener = new SculkCatalystPieEntity.CatalystListener(pBlockState, new BlockPositionSource(pPos));

    }

    public SculkCatalystPieEntity.CatalystListener getListener() {
        return this.catalystListener;
    }

    public static class CatalystListener implements GameEventListener {
        private final BlockState blockState;
        private final PositionSource positionSource;

        public CatalystListener(BlockState p_283224_, PositionSource p_283095_) {
            this.blockState = p_283224_;
            this.positionSource = p_283095_;
        }

        /**
         * Gets the position of the listener itself.
         */
        public PositionSource getListenerSource() {
            return this.positionSource;
        }

        /**
         * Gets the listening radius of the listener. Events within this radius will notify the listener when broadcasted.
         */
        public int getListenerRadius() {
            return 8;
        }

        public GameEventListener.DeliveryMode getDeliveryMode() {
            return GameEventListener.DeliveryMode.BY_DISTANCE;
        }

        public boolean handleGameEvent(ServerLevel p_283470_, GameEvent p_282184_, GameEvent.Context p_283014_, Vec3 p_282350_) {
            if (p_282184_ == GameEvent.ENTITY_DIE) {
                Entity $$5 = p_283014_.sourceEntity();
                if ($$5 instanceof LivingEntity) {
                    LivingEntity livingentity = (LivingEntity)$$5;
                    if (!livingentity.wasExperienceConsumed()) {
                        int i = livingentity.getExperienceReward();
                        if (livingentity.shouldDropExperience() && i > 0) {
                            this.tryAwardItSpreadsAdvancement(p_283470_, livingentity);
                        }

                        livingentity.skipDropExperience();
                        this.positionSource.getPosition(p_283470_).ifPresent((p_289513_) -> {
                            this.bloom(p_283470_, BlockPos.containing(p_289513_), this.blockState, p_283470_.getRandom());
                        });
                    }

                    return true;
                }
            }

            return false;
        }

        private void bloom(ServerLevel serverLevel, BlockPos pos, BlockState state, RandomSource randomSource) {
            safelyUpdate(serverLevel, pos, serverLevel.getBlockState(pos));
            serverLevel.sendParticles(ParticleTypes.SCULK_SOUL, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.15D, (double)pos.getZ() + 0.5D, 2, 0.2D, 0.0D, 0.2D, 0.0D);
            serverLevel.playSound((Player)null, pos, SoundEvents.SCULK_CATALYST_BLOOM, SoundSource.BLOCKS, 2.0F, 0.6F + randomSource.nextFloat() * 0.4F);
        }

        private void safelyUpdate(ServerLevel serverLevel, BlockPos pos, BlockState state) {
            if(state.hasProperty(PieBaseBlockEntity.BITES)) {
                int max = PieBaseBlockEntity.BITES.getPossibleValues().size();
                int curVal = state.getValue(PieBaseBlockEntity.BITES);
                if(curVal < max && curVal > 0) {
                    serverLevel.setBlock(pos, state.setValue(PieBaseBlockEntity.BITES, curVal - 1), 3);
                }
            }
        }


        private void tryAwardItSpreadsAdvancement(Level p_281279_, LivingEntity p_281378_) {
            LivingEntity livingentity = p_281378_.getLastHurtByMob();
            if (livingentity instanceof ServerPlayer serverplayer) {
                DamageSource damagesource = p_281378_.getLastDamageSource() == null ? p_281279_.damageSources().playerAttack(serverplayer) : p_281378_.getLastDamageSource();
                SDCriteriaTriggers.KILL_MOB_NEAR_SCULK_CATALYST_PIE.trigger(serverplayer, p_281378_, damagesource);
            }

        }
    }
}
