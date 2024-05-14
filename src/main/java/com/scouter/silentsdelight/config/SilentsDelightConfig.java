package com.scouter.silentsdelight.config;

import com.mojang.datafixers.util.Pair;
import com.scouter.silentsdelight.SilentsDelight;

public class SilentsDelightConfig {
    public static SimpleConfig CONFIG;
    private static SilentsDelightConfigProvider configs;
    public static boolean WARDEN_SENSE_SOUND;
    public static float WARDEN_SENSE_SOUND_VOLUME;

    public static void registerConfigs() {
        configs = new SilentsDelightConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(SilentsDelight.MODID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("warden_sense_sound", true), "When set to false it will disable warden sense sound");
        configs.addKeyValuePair(new Pair<>("warden_sense_sound_volume", 10F), "Change the volume of the sound played when using warden sense");

    }

    private static void assignConfigs() {
        WARDEN_SENSE_SOUND = CONFIG.getOrDefault("warden_sense_sound", true);
        WARDEN_SENSE_SOUND_VOLUME = CONFIG.getOrDefault("warden_sense_sound_volume", 10F);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
