package com.scouter.silentsdelight.items;


import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.blocks.SDBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.KelpRollItem;


public class SDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SilentsDelight.MODID);

    public static final RegistryObject<Item> WARDEN_EAR = ITEMS.register("warden_ear", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_EAR), true));

    public static final RegistryObject<Item> CUT_WARDEN_EAR = ITEMS.register("cut_warden_ear", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_EAR), true));

    public static final RegistryObject<Item> WARDEN_EAR_ON_A_STICK = ITEMS.register("warden_ear_on_a_stick", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_EAR_ON_A_STICK), true));

    public static final RegistryObject<Item> BAKED_WARDEN_EAR_ON_A_STICK = ITEMS.register("baked_warden_ear_on_a_stick", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.BAKED_WARDEN_EAR_ON_A_STICK), true));

    public static final RegistryObject<Item> WARDEN_EAR_FRIED_RICE = ITEMS.register("warden_ear_fried_rice", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_EAR_FRIED_RICE), true));

    public static final RegistryObject<Item> SCULK_SENSOR_TENDRIL = ITEMS.register("sculk_sensor_tendril", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SENSOR_TENDRIL), true));

    public static final RegistryObject<Item> SCULK_SENSOR_TENDRIL_ROLL = ITEMS.register("sculk_sensor_tendril_roll", () -> new KelpRollItem(new Item.Properties()
            .food(SDFoods.SCULK_SENSOR_TENDRIL_ROLL)));

    public static final RegistryObject<Item> SCULK_SENSOR_TENDRIL_ROLL_SLICE = ITEMS.register("sculk_sensor_tendril_roll_slice", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SENSOR_TENDRIL_SLICE), true));

    public static final RegistryObject<Item> SCULK_SENSOR_SPRINKLES = ITEMS.register("sculk_sensor_sprinkles", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SENSOR_SPRINKLES), true));

    public static final RegistryObject<Item> SCULK_BARBECUE_STICK = ITEMS.register("sculk_barbecue_stick", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_BARBECUE_STICK), true));

    public static final RegistryObject<Item> SCULK_SOUP = ITEMS.register("sculk_soup", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SOUP).craftRemainder(Items.BOWL), true));

    public static final RegistryObject<Item> SCULK_VEIN_SALAD = ITEMS.register("sculk_vein_salad", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_VEIN_SALAD), true));

    public static final RegistryObject<Item> SCULK_CATALYST_PIE_CRUST = ITEMS.register("sculk_catalyst_pie_crust",
            () -> new ConsumableItem(new Item.Properties()
                    .food(SDFoods.SCULK_CATALYST_PIE_CRUST), true));

    public static final RegistryObject<Item> SCULK_CATALYST_PIE = fromBlock(SDBlocks.SCULK_CATALYST_PIE);
    public static final RegistryObject<Item> SCULK_CATALYST_PIE_SLICE = ITEMS.register("sculk_catalyst_pie_slice", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_CATALYST_PIE_SLICE), true));

    public static final RegistryObject<Item> SCULK_SHRIEKER_SHAKE = ITEMS.register("sculk_shrieker_shake", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.SCULK_SHRIEKER_SHAKE).craftRemainder(Items.GLASS_BOTTLE), true));

    public static final RegistryObject<Item> WARDEN_HEART = ITEMS.register("warden_heart", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_HEART), true));

    public static final RegistryObject<Item> MINCED_WARDEN_HEART = ITEMS.register("minced_warden_heart", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.MINCED_WARDEN_HEART), true));

    public static final RegistryObject<Item> WARDEN_HEART_PATTY = ITEMS.register("warden_heart_patty", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.WARDEN_HEART_PATTY), true));

    public static final RegistryObject<Item> HEARTBURGER = ITEMS.register("heartburger", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.HEARTBURGER), true));

    public static final RegistryObject<Item> PLATED_WARDEN_HEART = fromBlock(SDBlocks.PLATED_WARDEN_HEART);
    public static final RegistryObject<Item> PLATE_OF_WARDEN_HEART = ITEMS.register("plate_of_warden_heart", () -> new ConsumableItem(new Item.Properties()
            .food(SDFoods.PLATE_OF_WARDEN_HEART).craftRemainder(Items.BOWL), true));

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
