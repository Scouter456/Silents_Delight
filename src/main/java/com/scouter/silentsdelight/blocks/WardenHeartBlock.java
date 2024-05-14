package com.scouter.silentsdelight.blocks;

import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.function.Supplier;

public class WardenHeartBlock extends FeastBlock {

    public WardenHeartBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }

    @Override
    public int getMaxServings() {
        return 2;
    }


}
