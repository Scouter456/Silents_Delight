package com.scouter.silentsdelight.items;

import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import com.scouter.silentsdelight.effects.SDEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class SDFoods {

    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes
    public static final FoodProperties WARDEN_EAR = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F)
            .effect( new MobEffectInstance(MobEffects.BLINDNESS, BRIEF_DURATION, 0), 1.0F)
            .build();


    public static final FoodProperties WARDEN_EAR_ON_A_STICK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3F)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties BAKED_WARDEN_EAR_ON_A_STICK = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.6F)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, SHORT_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(SDEffects.WARDENS_SENSE, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties WARDEN_EAR_FRIED_RICE = new FoodProperties.Builder()
            .nutrition(14).saturationMod(0.75f)
            .effect(new MobEffectInstance(EffectsRegistry.COMFORT.get(), LONG_DURATION, 0), 1.0F)
            //.effect(new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION, 0), 1.0F)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, SHORT_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(SDEffects.WARDENS_SENSE, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_SENSOR_TENDRIL = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.1F)
            //.effect(new MobEffectInstance(MobEffects.BLINDNESS, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_SENSOR_TENDRIL_ROLL = new FoodProperties.Builder()
            .nutrition(12)
            .saturationMod(0.6f)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, LONG_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_SENSOR_TENDRIL_SLICE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.5f)
            .fast()
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_SENSOR_SPRINKLES = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(0.5f)
            .fast()
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, LONG_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(SDEffects.WARDENS_SENSE, SHORT_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_BARBECUE_STICK = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.9f)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, SHORT_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_SOUP = new FoodProperties.Builder()
            .nutrition(12)
            .saturationMod(0.8f)
            .effect(new MobEffectInstance(EffectsRegistry.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            //.effect(new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, SHORT_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_VEIN_SALAD = new FoodProperties.Builder()
            .nutrition(6)
            .saturationMod(0.6f)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, BRIEF_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
            .build();


    public static final FoodProperties SCULK_CATALYST_PIE_CRUST = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.2f)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_CATALYST_PIE_SLICE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3f).fast()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, BRIEF_DURATION, 0, false, false), 1.0F)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, SHORT_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties SCULK_SHRIEKER_SHAKE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.3f)
            .alwaysEat()
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, SHORT_DURATION, 0), 1.0F)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, SHORT_DURATION, 0), 1.0F)
            .build();


    public static final FoodProperties WARDEN_HEART = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.6f)
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, BRIEF_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, BRIEF_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties MINCED_WARDEN_HEART = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.3f)
            .meat()
            .fast()
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, BRIEF_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, BRIEF_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, BRIEF_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties WARDEN_HEART_PATTY = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.8f)
            .meat()
            .fast()
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, LONG_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties HEARTBURGER = new FoodProperties.Builder()
            .nutrition(15)
            .saturationMod(1f)
            .meat()
            .fast()
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, LONG_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(SDEffects.WARDENS_SENSE, LONG_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, SHORT_DURATION, 2), 1.0F)
            .build();
    public static final FoodProperties PLATE_OF_WARDEN_HEART = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(1f)
            .meat()
            .fast()
            //.effect(new MobEffectInstance(SDEffects.ONE_OF_US, LONG_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(SDEffects.WARDENS_SENSE, LONG_DURATION, 0), 1.0F)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, BRIEF_DURATION, 2), 1.0F)
            .build();

}


