package com.scouter.silentsdelight.datagen;

import com.google.common.collect.ImmutableMap;
import com.scouter.silentsdelight.SilentsDelight;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(PackOutput output) {
        super(output, SilentsDelight.MODID, "en_us");
    }
    private final Set<Item> itemSet = new HashSet<>();

    static final Map<BlockFamily.Variant, BiConsumer<LanguageGenerator, Block>> SHAPE_CONSUMERS =
            ImmutableMap.<BlockFamily.Variant, BiConsumer<LanguageGenerator, Block>>builder()
                    .put(BlockFamily.Variant.BUTTON, LanguageGenerator::add)
                    .put(BlockFamily.Variant.DOOR, LanguageGenerator::add)
                    .put(BlockFamily.Variant.CHISELED, LanguageGenerator::add)
                    .put(BlockFamily.Variant.CRACKED, LanguageGenerator::add)
                    .put(BlockFamily.Variant.CUSTOM_FENCE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.FENCE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.CUSTOM_FENCE_GATE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.FENCE_GATE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.SIGN, LanguageGenerator::add)
                    .put(BlockFamily.Variant.SLAB, LanguageGenerator::add)
                    .put(BlockFamily.Variant.STAIRS, LanguageGenerator::add)
                    .put(BlockFamily.Variant.PRESSURE_PLATE, LanguageGenerator::add)
                    .put(BlockFamily.Variant.TRAPDOOR, LanguageGenerator::add)
                    .put(BlockFamily.Variant.WALL, LanguageGenerator::add)
                    .build();
    @Override
    protected void addTranslations() {
       // add(ABlocks.OORTALIT.get(), "Oortalit");

        add("itemGroup.silentsdelight", "Silent's Delight");
       
    }
    public void add(RegistryObject<Block> block, String name){
        add(block.get().asItem(), name);
    }

    public void add(Item key, String name) {
        itemSet.add(key);
        add(key.getDescriptionId(), name);
    }

    public void addLeftOver(Item key) {
        //if(key instanceof BlockItem item && item.getBlock() instanceof WallSignBlock) return;
        String keyDescription = name(key);
        String[] parts = keyDescription.replace("item.scalebound.", "").split("_");
        StringBuilder modifiedString = new StringBuilder();
        int i = 0;
        for (String part : parts) {
            if(0 == i){
                modifiedString.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            } else {
                modifiedString.append(" ").append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            }
            i++;
        }
        modifiedString.trimToSize();
        String finalModifiedString = modifiedString.toString();
        add(key, finalModifiedString);
    }

    public void add(Block key) {
        //if(key instanceof WallSignBlock) return;
        itemSet.add(key.asItem());
        String keyDescription = key.getDescriptionId();
        String[] parts = keyDescription.replace("block.scalebound.", "").split("_");
        StringBuilder modifiedString = new StringBuilder();
        int i = 0;
        for (String part : parts) {
            if(0 == i){
                modifiedString.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            } else {
                modifiedString.append(" ").append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
            }
            i++;
        }
        modifiedString.trimToSize();
        String finalModifiedString = modifiedString.toString();
        add(key.getDescriptionId(), finalModifiedString);
    }

    private String name(Item block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Item block) {
        return BuiltInRegistries.ITEM.getKey(block);
    }

}

