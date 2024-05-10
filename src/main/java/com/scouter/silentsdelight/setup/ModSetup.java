package com.scouter.silentsdelight.setup;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.message.SDMessages;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = SilentsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static void init(FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
        });
        SDMessages.register();
    }

    public static void setup(){
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }
}
