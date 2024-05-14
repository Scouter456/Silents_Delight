package com.scouter.silentsdelight.blocks;

import com.scouter.silentsdelight.SilentsDelight;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = SilentsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SDBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SilentsDelight.MODID);

    public static final RegistryObject<BlockEntityType<SculkCatalystPieEntity>> CATALYST_PIE = BLOCK_ENTITY.register("catalyst_pie",
            () -> BlockEntityType.Builder.of(SculkCatalystPieEntity::new, SDBlocks.SCULK_CATALYST_PIE.get()).build(null));

}
