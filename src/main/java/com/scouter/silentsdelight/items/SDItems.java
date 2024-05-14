package com.scouter.silentsdelight.items;


import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.blocks.SDBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.KelpRollItem;

import static com.scouter.silentsdelight.SilentsDelight.prefix;


public class SDItems {
    public static final Logger LOGGER = LoggerFactory.getLogger(SilentsDelight.MODID);
    public static final Item WARDEN_EAR = registerItem("warden_ear", new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_EAR), true));

    public static final Item CUT_WARDEN_EAR = registerItem("cut_warden_ear", new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_EAR), true));

    public static final Item WARDEN_EAR_ON_A_STICK = registerItem("warden_ear_on_a_stick", new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_EAR_ON_A_STICK), true));

    public static final Item BAKED_WARDEN_EAR_ON_A_STICK = registerItem("baked_warden_ear_on_a_stick", new ConsumableItem(new Item.Properties()
            .food(SDFoods.BAKED_WARDEN_EAR_ON_A_STICK), true));

    public static final Item WARDEN_EAR_FRIED_RICE = registerItem("warden_ear_fried_rice", new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_EAR_FRIED_RICE), true));

    public static final Item SCULK_SENSOR_TENDRIL = registerItem("sculk_sensor_tendril", new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SENSOR_TENDRIL), true));

    public static final Item SCULK_SENSOR_TENDRIL_ROLL = registerItem("sculk_sensor_tendril_roll", new KelpRollItem(new Item.Properties()
            .food(SDFoods.SCULK_SENSOR_TENDRIL_ROLL)));

    public static final Item SCULK_SENSOR_TENDRIL_ROLL_SLICE = registerItem("sculk_sensor_tendril_roll_slice", new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SENSOR_TENDRIL_SLICE), true));

    public static final Item SCULK_SENSOR_SPRINKLES = registerItem("sculk_sensor_sprinkles", new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SENSOR_SPRINKLES), true));

    public static final Item SCULK_BARBECUE_STICK = registerItem("sculk_barbecue_stick", new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_BARBECUE_STICK), true));

    public static final Item SCULK_SOUP = registerItem("sculk_soup", new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SOUP).craftRemainder(Items.BOWL), true));

    public static final Item SCULK_VEIN_SALAD = registerItem("sculk_vein_salad", new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_VEIN_SALAD), true));

    public static final Item SCULK_CATALYST_PIE_CRUST = registerItem("sculk_catalyst_pie_crust",
            new ConsumableItem(new Item.Properties()
                    .food(SDFoods.SCULK_CATALYST_PIE_CRUST), true));

    public static final Item SCULK_CATALYST_PIE = registerBlockItem(SDBlocks.SCULK_CATALYST_PIE);
    public static final Item SCULK_CATALYST_PIE_SLICE = registerItem("sculk_catalyst_pie_slice", new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_CATALYST_PIE_SLICE), true));

    public static final Item SCULK_SHRIEKER_SHAKE = registerItem("sculk_shrieker_shake", new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SHRIEKER_SHAKE).craftRemainder(Items.GLASS_BOTTLE), true));

    public static final Item WARDEN_HEART = registerItem("warden_heart", new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_HEART), true));

    public static final Item MINCED_WARDEN_HEART = registerItem("minced_warden_heart", new ConsumableItem(new Item.Properties()
            .food(SDFoods.MINCED_WARDEN_HEART), true));

    public static final Item WARDEN_HEART_PATTY = registerItem("warden_heart_patty", new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_HEART_PATTY), true));

    public static final Item HEARTBURGER = registerItem("heartburger", new ConsumableItem(new Item.Properties()
            .food(SDFoods.HEARTBURGER), true));

    public static final Item PLATED_WARDEN_HEART = registerBlockItem(SDBlocks.PLATED_WARDEN_HEART);
    public static final Item PLATE_OF_WARDEN_HEART = registerItem("plate_of_warden_heart", new ConsumableItem(new Item.Properties()
            .food(SDFoods.PLATE_OF_WARDEN_HEART).craftRemainder(Items.BOWL), true));

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, prefix(name), item);
    }

    private static Item registerBlockItem(Block block){
        return Registry.register(BuiltInRegistries.ITEM, prefix(block.getDescriptionId().replace("block.silentsdelight.", "").toString()),
                new BlockItem(block, new FabricItemSettings().fireproof()));
    }

    public static void ITEMS(){
        LOGGER.info("Registering Items for " + SilentsDelight.MODID);
    }
}
