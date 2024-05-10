package com.scouter.silentsdelight.setup;


import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.client.renderer.RenderLayerRegistration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SilentsDelight.MODID, value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(FMLClientSetupEvent event){
        RenderLayerRegistration.init();
    }

}

