package com.scouter.silentsdelight.blocks;

import com.scouter.silentsdelight.SilentsDelight;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = SilentsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ODBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SilentsDelight.MODID);

}
