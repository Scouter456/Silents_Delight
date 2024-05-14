package com.scouter.silentsdelight.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.scouter.silentsdelight.effects.SDEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(VibrationSystem.Listener.class)
public class VibrationSystemListenerMixin {

    @ModifyExpressionValue(method = "handleGameEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/gameevent/vibrations/VibrationSystem$User;isValidVibration(Lnet/minecraft/world/level/gameevent/GameEvent;Lnet/minecraft/world/level/gameevent/GameEvent$Context;)Z"))
    private boolean silentsdelight$isValidVibration(boolean original, ServerLevel level, GameEvent event, GameEvent.Context context) {
        Entity entity = context.sourceEntity();
        if (entity instanceof LivingEntity livingEntity) {
            //todo add custom effect called ONE_OF_THEM this makes the sculks see you as one of them :)
            if (livingEntity.hasEffect(SDEffects.ONE_OF_US)) {
                    return false;
            }
        }
        return original;
    }
}
