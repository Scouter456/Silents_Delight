package com.scouter.silentsdelight.creativetabs;

import com.scouter.silentsdelight.SilentsDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SDTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SilentsDelight.MODID);

    private static final CreativeModeTab FOODS = new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 9)
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .title(Component.translatable("itemGroup.silentsdelight"))
            .icon(() -> new ItemStack(Items.SOUL_SAND))
            .displayItems((d, entries) -> {

            })
            .build();


    public static final RegistryObject<CreativeModeTab> SD_TAB = TABS.register("silentsdelight", () -> FOODS);
}
