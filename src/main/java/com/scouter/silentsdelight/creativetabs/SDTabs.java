package com.scouter.silentsdelight.creativetabs;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.items.SDItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.silentsdelight.SilentsDelight.prefix;

public class SDTabs {

    public static final Logger LOGGER = LoggerFactory.getLogger(SilentsDelight.MODID);

    private static final CreativeModeTab FOODS = FabricItemGroup
            .builder()
            .title(Component.translatable("itemGroup.silentsdelight"))
            .icon(SDItems.WARDEN_HEART::getDefaultInstance)
            .displayItems((d, entries) -> {
                entries.accept(SDItems.WARDEN_EAR);
                entries.accept(SDItems.CUT_WARDEN_EAR);
                entries.accept(SDItems.WARDEN_EAR_ON_A_STICK);
                entries.accept(SDItems.BAKED_WARDEN_EAR_ON_A_STICK);
                entries.accept(SDItems.WARDEN_EAR_FRIED_RICE);
                entries.accept(SDItems.SCULK_SENSOR_TENDRIL);
                entries.accept(SDItems.SCULK_SENSOR_TENDRIL_ROLL);
                entries.accept(SDItems.SCULK_SENSOR_TENDRIL_ROLL_SLICE);
                entries.accept(SDItems.SCULK_SENSOR_SPRINKLES);
                entries.accept(SDItems.SCULK_BARBECUE_STICK);
                entries.accept(SDItems.SCULK_SOUP);
                entries.accept(SDItems.SCULK_VEIN_SALAD);
                entries.accept(SDItems.SCULK_CATALYST_PIE_CRUST);
                entries.accept(SDItems.SCULK_CATALYST_PIE);
                entries.accept(SDItems.SCULK_CATALYST_PIE_SLICE);
                entries.accept(SDItems.SCULK_SHRIEKER_SHAKE);
                entries.accept(SDItems.WARDEN_HEART);
                entries.accept(SDItems.MINCED_WARDEN_HEART);
                entries.accept(SDItems.WARDEN_HEART_PATTY);
                entries.accept(SDItems.HEARTBURGER);
                entries.accept(SDItems.PLATED_WARDEN_HEART);
                entries.accept(SDItems.PLATE_OF_WARDEN_HEART);
            })
            .build();


    public static final CreativeModeTab SD_TAB = creativeModeTab("silentsdelight", FOODS);

    private static CreativeModeTab creativeModeTab(String name, CreativeModeTab item) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, prefix(name), item);
    }


    public static void TABS() {
        LOGGER.info("Registering tabs for " + SilentsDelight.MODID);
    }
}
