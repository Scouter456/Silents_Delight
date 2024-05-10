package com.scouter.silentsdelight.message;

import com.scouter.silentsdelight.SilentsDelight;
import com.scouter.silentsdelight.player.VibrationEntities;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public record EntityRenderOutlineMessage<D>(UUID sender, int entityId) {

    public static final ResourceLocation ID = new ResourceLocation(SilentsDelight.MODID, "entity_render_outline");


    //@Override
    public void write(FriendlyByteBuf buffer) {
        buffer.writeUUID(this.sender);
        buffer.writeVarInt(this.entityId);
    }

    public static <D> EntityRenderOutlineMessage<D> decode(FriendlyByteBuf buffer) {
        return new EntityRenderOutlineMessage<>(buffer.readUUID(), buffer.readVarInt());
    }

    //public void receivePacket(PlayPayloadContext context) {
    //    context.workHandler().execute(() -> {
    //        VibrationEntities.addToShow(sender, entityId);
    //    });
    //}

    public void onPacketReceived(Supplier<NetworkEvent.Context> contextGetter) {
        NetworkEvent.Context context = contextGetter.get();
        context.enqueueWork(() -> VibrationEntities.addToShow(sender, entityId));
        context.setPacketHandled(true);
    }

   //@Override
   //public ResourceLocation id() {
   //    return ID;
   //}
}
