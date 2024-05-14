package com.scouter.silentsdelight.datagen;

import com.google.common.collect.ImmutableMap;
import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.effects.SDEffects;
import com.scouter.silentsdelight.items.SDItems;
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
        add(SDItems.WARDEN_EAR, "Warden Ear");
        add(SDItems.CUT_WARDEN_EAR, "Cut Warden Ear");
        add(SDItems.WARDEN_EAR_ON_A_STICK, "Warden Ear on a Stick");
        add(SDItems.BAKED_WARDEN_EAR_ON_A_STICK, "Baked Warden Ear on a Stick");
        add(SDItems.WARDEN_EAR_FRIED_RICE, "Warden Ear Fried Rice");
        add(SDItems.SCULK_SENSOR_TENDRIL, "Sculk Sensor Tendril");
        add(SDItems.SCULK_SENSOR_TENDRIL_ROLL, "Sculk Sensor Tendril Roll");
        add(SDItems.SCULK_SENSOR_TENDRIL_ROLL_SLICE, "Sculk Sensor Tendril Roll Slice");
        add(SDItems.SCULK_SENSOR_SPRINKLES , "Sculk Sensor Sprinkles");
        add(SDItems.SCULK_BARBECUE_STICK, "Sculk Barbecue Stick");
        add(SDItems.SCULK_SOUP, "Sculk Soup");
        add(SDItems.SCULK_VEIN_SALAD, "Sculk Vein Salad");
        add(SDItems.SCULK_CATALYST_PIE_CRUST, "Sculk Catalyst Pie Crust");
        add(SDItems.SCULK_CATALYST_PIE, "Sculk Catalyst Pie");
        add(SDItems.SCULK_CATALYST_PIE_SLICE, "Sculk Catalyst Pie Slice");
        add(SDItems.SCULK_SHRIEKER_SHAKE, "Sculk Shrieker Shake");
        add(SDItems.WARDEN_HEART, "Warden Heart");
        add(SDItems.MINCED_WARDEN_HEART, "Minced Warden Heart");
        add(SDItems.WARDEN_HEART_PATTY, "Warden Heart Patty");
        add(SDItems.HEARTBURGER, "Heartburger");
        add(SDItems.PLATED_WARDEN_HEART, "Plated Warden Heart");
        add(SDItems.PLATE_OF_WARDEN_HEART, "Plate of Warden Heart");
        add(SDEffects.WARDENS_SENSE.get(), "Warden Sense");
        add("silentsdelight.advancement.root.desc", "This can be eaten?");
        add("silentsdelight.advancement.root", "A feast of the depths!");
        add("silentsdelight.advancement.obtain_warden_ear", "It can still hear me!");
        add("silentsdelight.advancement.obtain_warden_ear.desc", "Obtain a Warden Ear");
        add("silentsdelight.advancement.obtain_warden_ear_fried_rice.desc", "Cook a Warden Ear fried rice!");
        add("silentsdelight.advancement.obtain_warden_ear_fried_rice", "A hearty meal");
        add("silentsdelight.advancement.obtain_baked_warden_ear", "Be Silent!");
        add("silentsdelight.advancement.obtain_baked_warden_ear.desc", "Bake a Warden Ear");
        add("silentsdelight.advancement.grow_sculk_catalyst_pie", "It Grows!");
        add("silentsdelight.advancement.grow_sculk_catalyst_pie.desc", "Kill next to a Catalyst Pie and... obtain more Pie!");
        add("silentsdelight.advancement.get_warden_heartburger", "Silent but deadly");
        add("silentsdelight.advancement.get_warden_heartburger.desc", "Make a Heartburger");
        add("silentsdelight.advancement.get_warden_heart.desc", "Obtain a Warden Heart");
        add("silentsdelight.advancement.get_warden_heart", "A hard fought battle!");
        add("silentsdelight.advancement.get_sculk_vein_salad", "It's still moving!");
        add("silentsdelight.advancement.get_sculk_vein_salad.desc", "Craft a Sculk Vein Salad");
        add("silentsdelight.advancement.get_sculk_soup", "Peer into the depths");
        add("silentsdelight.advancement.get_sculk_soup.desc", "Cook Sculk Soup");
        add("silentsdelight.advancement.get_sculk_shrieker_shake", "Shh be silent!");
        add("silentsdelight.advancement.get_sculk_shrieker_shake.desc", "Craft a Sculk Shrieker Shake");
        add("silentsdelight.advancement.get_sculk_sensor_tendril_sprinkles.desc", "Sprinkled Delight");
        add("silentsdelight.advancement.get_sculk_sensor_tendril_sprinkles", "Craft a Sculk Sensor Tendril Sprinkles");
        add("silentsdelight.advancement.get_sculk_sensor_tendril_roll", "Rolled Sensor");
        add("silentsdelight.advancement.get_sculk_sensor_tendril_roll.desc", "Craft a Sculk Sensor Tendril Roll");
        add("silentsdelight.advancement.get_sculk_sensor_tendril", "A senseful food");
        add("silentsdelight.advancement.get_sculk_sensor_tendril.desc", "Obtain Sculk Sensor Tendrils");
        add("silentsdelight.advancement.get_sculk_catalyst_pie", "A pie with depth");
        add("silentsdelight.advancement.get_sculk_catalyst_pie.desc", "Craft a Sculk Catalyst Pie");
        add("silentsdelight.advancement.get_plated_warden_heart", "Does it still beat?");
        add("silentsdelight.advancement.get_plated_warden_heart.desc", "Craft a plate of Warden Heart");

    }


    public void add(RegistryObject<Item> block, String name){
        add(block.get(), name);
    }

    public void add(Item key, String name) {
        itemSet.add(key);
        add(key.getDescriptionId(), name);
    }

    public void addLeftOver(Item key) {
        //if(key instanceof BlockItem item && item.getBlock() instanceof WallSignBlock) return;
        String keyDescription = name(key);
        String[] parts = keyDescription.replace("item.silentsdelight.", "").split("_");
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

