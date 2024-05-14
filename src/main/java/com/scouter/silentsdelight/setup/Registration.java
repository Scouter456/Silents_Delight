package com.scouter.silentsdelight.setup;

import com.mojang.logging.LogUtils;
import com.scouter.silentsdelight.advancements.SDCriteriaTriggers;
import com.scouter.silentsdelight.blocks.SDBlockEntities;
import com.scouter.silentsdelight.blocks.SDBlocks;
import com.scouter.silentsdelight.creativetabs.SDTabs;
import com.scouter.silentsdelight.effects.SDEffects;
import com.scouter.silentsdelight.items.SDItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


public class Registration {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static void init(){

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        SDBlocks.BLOCKS.register(bus);
        SDBlockEntities.BLOCK_ENTITY.register(bus);
        SDItems.ITEMS.register(bus);
        SDTabs.TABS.register(bus);
        SDEffects.MOB_EFFECTS.register(bus);
        SDCriteriaTriggers.init();
    }
}
