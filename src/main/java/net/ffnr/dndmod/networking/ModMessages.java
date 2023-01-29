package net.ffnr.dndmod.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.ffnr.dndmod.DndMod;
import net.ffnr.dndmod.networking.packet.ExampleC2SPacket;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier XP_ID = new Identifier(DndMod.MOD_ID, "xp");
    public static final Identifier XP_SYNC_ID = new Identifier(DndMod.MOD_ID, "xp_sync");
    public static final Identifier EXAMPLE_ID = new Identifier(DndMod.MOD_ID, "example");

    public static void registerC2SPackets()
    {
        ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::recieve);
    }

    public static void registerS2CPackets()
    {

    }
}
