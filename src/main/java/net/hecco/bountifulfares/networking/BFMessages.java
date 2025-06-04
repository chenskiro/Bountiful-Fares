package net.hecco.bountifulfares.networking;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.resources.ResourceLocation;

public class BFMessages {

    public static final ResourceLocation CERAMIC_DISH_ITEM_SYNC = BountifulFares.rl( "ceramic_dish_item_sync");
    public static final ResourceLocation CERAMIC_COLOR_SYNC = BountifulFares.rl( "ceramic_color_sync");

    public static void registerS2CPackets() {
//        ClientPlayNetworking.registerGlobalReceiver(CERAMIC_DISH_ITEM_SYNC, ItemStackS2CPacket::receive);
//        ClientPlayNetworking.registerGlobalReceiver(CERAMIC_COLOR_SYNC, CeramicColorS2CPacket::receive);
    }
}
