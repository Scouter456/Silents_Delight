package com.scouter.silentsdelight.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.structure.StructureSet;

import static com.scouter.silentsdelight.SilentsDelight.prefix;

public class SDTags {


    //public static final TagKey<Biome> IS_GARLIC_BIOME = registerBiomeTag("is_garlic_biome");


    private static TagKey<Biome> registerBiomeTag(String name){
        return TagKey.create(Registries.BIOME, prefix(name));

    }

    private static TagKey<Block> registerBlockTag(String name){
        return TagKey.create(Registries.BLOCK, prefix(name));
    }

    private static TagKey<Instrument> registerInstrument(String name) {
        return TagKey.create(Registries.INSTRUMENT, prefix( name));
    }

    private static TagKey<StructureSet> registerStructureSet(String name) {
        return TagKey.create(Registries.STRUCTURE_SET, prefix( name));
    }

    private static TagKey<DamageType> registerDamageType(String name) {
        return TagKey.create(Registries.DAMAGE_TYPE, prefix( name));
    }
}
