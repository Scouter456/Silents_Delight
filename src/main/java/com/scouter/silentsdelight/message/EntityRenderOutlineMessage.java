package com.scouter.silentsdelight.message;

import com.scouter.silentsdelight.SilentsDelight;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public class EntityRenderOutlineMessage {

    public static final ResourceLocation ID = new ResourceLocation(SilentsDelight.MODID, "entity_render_outline");


    //@Override
    public static FriendlyByteBuf write(UUID sender, int entityId) {
        FriendlyByteBuf buffer = PacketByteBufs.create();
        buffer.writeUUID(sender);
        buffer.writeVarInt(entityId);
        return buffer;
    }
}
