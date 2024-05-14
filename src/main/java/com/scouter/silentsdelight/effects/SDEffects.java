package com.scouter.silentsdelight.effects;

import com.scouter.silentsdelight.SilentsDelight;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.silentsdelight.SilentsDelight.prefix;

public class SDEffects {
    public static final Logger LOGGER = LoggerFactory.getLogger(SilentsDelight.MODID);

    public static final MobEffect ONE_OF_US = registerEffect("one_of_us", new OneOfUsEffect(MobEffectCategory.BENEFICIAL, 0x1c9c9e));
    public static final MobEffect WARDENS_SENSE = registerEffect("warden_sense", new WardenSenseEffect(MobEffectCategory.BENEFICIAL, 0x009295));

    public static MobEffect registerEffect(String name, MobEffect effect){
        return Registry.register(BuiltInRegistries.MOB_EFFECT, prefix(name), effect);
    }
    public static void MOBEFFECTS()
    {
        LOGGER.info("Registering Effects for " + SilentsDelight.MODID);
    }
}
