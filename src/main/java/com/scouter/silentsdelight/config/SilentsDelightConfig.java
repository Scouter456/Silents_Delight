package com.scouter.silentsdelight.config;

import com.scouter.silentsdelight.SilentsDelight;
import net.minecraftforge.common.ForgeConfigSpec;

public class SilentsDelightConfig {



    public static final ForgeConfigSpec CONFIG_BUILDER;

    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        setupConfig(configBuilder);
        CONFIG_BUILDER = configBuilder.build();
    }

    public static ForgeConfigSpec.ConfigValue<Boolean> WARDEN_SENSE_SOUND;
    public static ForgeConfigSpec.ConfigValue<Float> WARDEN_SENSE_SOUND_VOLUME;


    private static void setupConfig(ForgeConfigSpec.Builder builder) {
        builder.comment(SilentsDelight.MODID + " Config");

        builder.comment("Config for the Silents Delight");
        WARDEN_SENSE_SOUND = builder.comment("When set to false it will disable warden sense sound").define("warden_sense_sound", true);
        WARDEN_SENSE_SOUND_VOLUME = builder.comment("Change the volume of the sound played when using warden sense").define("warden_sense_sound_volume", 10F);

    }
}
