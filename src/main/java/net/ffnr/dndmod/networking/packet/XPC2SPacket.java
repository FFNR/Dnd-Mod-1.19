package net.ffnr.dndmod.networking.packet;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.ffnr.dndmod.event.OnDeathEntityHandler;
import net.ffnr.dndmod.util.IEntityDataSaver;
import net.ffnr.dndmod.util.XpData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.EntityPositionSource;

public class XPC2SPacket {
    public static void recieve(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf bug, PacketSender responseSender){
        //Happens on the server
        ServerWorld world = player.getWorld();

        if(OnDeathEntityHandler.getKilledPasive()) {
            XpData.addExperience(((IEntityDataSaver) player), 10);
            player.sendMessage(Text.literal("XP Total: " + (XpData.getExperience(((IEntityDataSaver) player)))));
        }


    }
}