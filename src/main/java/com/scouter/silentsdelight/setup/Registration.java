package com.scouter.silentsdelight.setup;

import com.mojang.logging.LogUtils;
import com.scouter.silentsdelight.advancements.SDCriteriaTriggers;
import com.scouter.silentsdelight.blocks.SDBlockEntities;
import com.scouter.silentsdelight.blocks.SDBlocks;
import com.scouter.silentsdelight.creativetabs.SDTabs;
import com.scouter.silentsdelight.effects.SDEffects;
import com.scouter.silentsdelight.items.SDItems;
import org.slf4j.Logger;


public class Registration {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static void init(){
        SDItems.ITEMS();
        SDBlockEntities.BLOCK_ENTITIES();
        SDBlocks.BLOCKS();
        SDTabs.TABS();
        SDEffects.MOBEFFECTS();
        SDCriteriaTriggers.init();

    }

}
