package com.scouter.silentsdelight.blocks;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.items.SDItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

@Mod.EventBusSubscriber(modid = SilentsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SilentsDelight.MODID);

    public static final RegistryObject<Block> SCULK_CATALYST_PIE = BLOCKS.register("sculk_catalyst_pie",
            () -> new SculkCatalystPie(Block.Properties.copy(Blocks.CAKE), SDItems.SCULK_CATALYST_PIE_SLICE));

    public static final RegistryObject<Block> PLATED_WARDEN_HEART = BLOCKS.register("plated_warden_heart",
            () -> new WardenHeartBlock(Block.Properties.copy(Blocks.CAKE), SDItems.PLATE_OF_WARDEN_HEART, true));
}
