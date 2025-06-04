// package net.hecco.bountifulfares.networking.packet;
//
// import net.fabricmc.fabric.api.networking.v1.PacketSender;
// import net.hecco.bountifulfares.block.entity.CeramicDishBlockEntity;
// import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
// import net.minecraft.client.Minecraft;
// import net.minecraft.client.multiplayer.ClientPacketListener;
// import net.minecraft.core.BlockPos;
// import net.minecraft.network.FriendlyByteBuf;
//
// public class CeramicColorS2CPacket {
//     public static void receive(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender) {
//         int color = buf.readInt();
//         BlockPos position = buf.readBlockPos();
//         if(client.level.getBlockEntity(position) instanceof DyeableCeramicBlockEntity entity) {
//             entity.color = color;
//         }
//         if(client.level.getBlockEntity(position) instanceof CeramicDishBlockEntity entity) {
//             entity.color = color;
//         }
//     }
// }
