package com.scouter.silentsdelight.blocks;

import com.nhoryzon.mc.farmersdelight.block.FeastBlock;
import com.scouter.silentsdelight.items.SDItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WardenHeartBlock extends EFeastBlock {

    public WardenHeartBlock() {
        super(Block.Properties.copy(Blocks.CAKE), () -> SDItems.PLATE_OF_WARDEN_HEART, true);
    }

    @Override
    public int getMaxServings() {
        return 2;
    }


}
