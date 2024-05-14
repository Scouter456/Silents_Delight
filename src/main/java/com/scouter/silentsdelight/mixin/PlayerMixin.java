package com.scouter.silentsdelight.mixin;

import com.mojang.authlib.GameProfile;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;
import com.scouter.silentsdelight.player.PlayerVibration;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;

@Mixin(ServerPlayer.class)
public abstract class PlayerMixin extends Player implements  VibrationSystem {

    private static final Logger LOGGER = LogUtils.getLogger();
    public DynamicGameEventListener<Listener> dynamicGameEventListener;
    private User vibrationUser;
    private Data vibrationData;

    public PlayerMixin(Level pLevel, BlockPos pPos, float pYRot, GameProfile pGameProfile) {
        super(pLevel, pPos, pYRot, pGameProfile);
    }


    @Inject(at = @At("TAIL"), method = "<init>")
    private void silentsdelight$addVibrationListener(MinecraftServer pServer, ServerLevel pLevel, GameProfile pGameProfile, CallbackInfo ci) {
        ServerPlayer entity = (ServerPlayer) (Object) this;
        this.vibrationData = new Data();
        this.vibrationUser = new PlayerVibration.VibrationUser(entity);
        this.dynamicGameEventListener = new DynamicGameEventListener<Listener>(new Listener(this));
    }


    @Inject(at = @At("TAIL"), method = "addAdditionalSaveData")
    public void addAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
            Data.CODEC.encodeStart(NbtOps.INSTANCE, this.vibrationData).resultOrPartial(LOGGER::error).ifPresent(tag -> compound.put("silentsdelight_listener", (Tag) tag));
    }

    @Inject(at = @At("TAIL"), method = "readAdditionalSaveData")
    public void readAdditionalSaveData(CompoundTag compound, CallbackInfo ci) {
            if (compound.contains("silentsdelight_listener", 10)) {
                Data.CODEC.parse(new Dynamic<>(NbtOps.INSTANCE, compound.getCompound("silentsdelight_listener"))).resultOrPartial(LOGGER::error).ifPresent(data -> {
                    this.vibrationData = data;
                });
            }
    }

    @Override
    public Data getVibrationData() {
        return this.vibrationData;
    }

    @Override
    public User getVibrationUser() {
        return this.vibrationUser;
    }

    @Inject(at = @At("TAIL"), method = "tick")
    public void tick(CallbackInfo ci) {
        if (this.level()instanceof ServerLevel serverLevel)
                Ticker.tick(serverLevel, this.vibrationData, this.vibrationUser);
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> biConsumer) {
        if (level()instanceof ServerLevel serverLevel)
            biConsumer.accept(this.dynamicGameEventListener, serverLevel);
    }
}
