package com.scouter.silentsdelight.blocks;

import com.scouter.silentsdelight.SilentsDelight;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.scouter.silentsdelight.SilentsDelight.prefix;

public class SDBlockEntities {
    public static final Logger LOGGER = LoggerFactory.getLogger(SilentsDelight.MODID);

    public static final BlockEntityType<SculkCatalystPieEntity> CATALYST_PIE =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,prefix("catalyst_pie"),
                    FabricBlockEntityTypeBuilder.create(SculkCatalystPieEntity::new,
                            SDBlocks.SCULK_CATALYST_PIE).build());


    public static void BLOCK_ENTITIES(){
        LOGGER.info("Registering Block Entities for " + SilentsDelight.MODID);
    }
}
