package net.ffnr.dndmod.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.ffnr.dndmod.dnd.Character;
import net.ffnr.dndmod.networking.ModMessages;
import net.ffnr.dndmod.util.XpData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.ActionResult;

public class OnDeathEntityHandler implements ServerLivingEntityEvents.AfterDeath{
    public static boolean killedPassive = false;

    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {

        if(entity instanceof CowEntity || entity instanceof SheepEntity || entity instanceof PigEntity || entity instanceof HorseEntity){

            killedPasive();

        }



    }

    public static void killedPasive(){
        killedPassive = true;
        ClientPlayNetworking.send(ModMessages.XP_ID, PacketByteBufs.create());


    }
    public static boolean getKilledPasive()
    {
        killedPassive = false;
        return true;
    }
}
