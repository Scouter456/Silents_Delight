package com.scouter.silentsdelight.effects;

import com.scouter.silentsdelight.SilentsDelight;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SDEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SilentsDelight.MODID);
    //public static final RegistryObject<MobEffect> ONE_OF_US = MOB_EFFECTS.register("one_of_us", () -> new OneOfUsEffect(MobEffectCategory.BENEFICIAL, 0x1c9c9e));
    public static final RegistryObject<MobEffect> WARDENS_SENSE = MOB_EFFECTS.register("warden_sense", () -> new WardenSenseEffect(MobEffectCategory.BENEFICIAL, 0x009295));

}
