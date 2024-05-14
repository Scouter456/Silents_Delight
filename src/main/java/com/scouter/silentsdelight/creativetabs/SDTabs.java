package com.scouter.silentsdelight.creativetabs;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.items.SDItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SDTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SilentsDelight.MODID);

    private static final CreativeModeTab FOODS = new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 9)
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.silentsdelight"))
            .icon(() -> new ItemStack(Items.SOUL_SAND))
            .displayItems((d, entries) -> {
                for(RegistryObject<Item> item : SDItems.ITEMS.getEntries()) {
                    entries.accept(item.get());
                }
            })
            .build();


    public static final RegistryObject<CreativeModeTab> SD_TAB = TABS.register("silentsdelight", () -> FOODS);
}
