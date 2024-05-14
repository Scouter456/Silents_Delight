package com.scouter.silentsdelight.setup;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.items.SDItems;
import com.scouter.silentsdelight.message.SDMessages;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import vectorwing.farmersdelight.common.registry.ModItems;

@Mod.EventBusSubscriber(modid = SilentsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static void init(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(SDItems.SCULK_SENSOR_TENDRIL_ROLL.get(), 0.85F);
            ComposterBlock.COMPOSTABLES.put(SDItems.SCULK_CATALYST_PIE.get(), 1.0F);

        });
        SDMessages.register();
    }

    public static void setup(){
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }
}
