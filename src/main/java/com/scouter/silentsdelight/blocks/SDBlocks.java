package com.scouter.silentsdelight.blocks;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.items.SDItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.silentsdelight.SilentsDelight.prefix;

public class SDBlocks {
    public static final Logger LOGGER = LoggerFactory.getLogger(SilentsDelight.MODID);

    public static final Block SCULK_CATALYST_PIE = registerBlock("sculk_catalyst_pie",
            new SculkCatalystPie(Block.Properties.copy(Blocks.CAKE), () ->SDItems.SCULK_CATALYST_PIE_SLICE));

    public static final Block PLATED_WARDEN_HEART = registerBlock("plated_warden_heart", new WardenHeartBlock());


    private static Block registerBlock(String name, Block block){
        return Registry.register(BuiltInRegistries.BLOCK, prefix(name), block);
    }

    public static void BLOCKS(){
        LOGGER.info("Registering Blocks for " + SilentsDelight.MODID);
    }
}
