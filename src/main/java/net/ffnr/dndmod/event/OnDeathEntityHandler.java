package net.ffnr.dndmod.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.ffnr.dndmod.dnd.Character;
import net.ffnr.dndmod.networking.ModMessages;
import net.ffnr.dndmod.util.XpData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.SkeletonHorseEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.ActionResult;

public class OnDeathEntityHandler implements ServerLivingEntityEvents.AfterDeath{
    public static boolean killedPassive = false;

    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {

        if(entity instanceof CowEntity || entity instanceof SheepEntity || entity instanceof PigEntity ||
                entity instanceof HorseEntity || entity instanceof ChickenEntity || entity instanceof BatEntity ||
                entity instanceof  OcelotEntity || entity instanceof PandaEntity || entity instanceof FoxEntity ||
                entity instanceof SquidEntity || entity instanceof FishEntity || entity instanceof MooshroomEntity ||
                entity instanceof DonkeyEntity || entity instanceof MuleEntity || entity instanceof DolphinEntity ||
                entity instanceof BeeEntity || entity instanceof RabbitEntity || entity instanceof CodEntity ||
                entity instanceof SalmonEntity || entity instanceof ParrotEntity || entity instanceof SkeletonHorseEntity ||
                entity instanceof TropicalFishEntity || entity instanceof TurtleEntity || entity instanceof VillagerEntity ||
                entity instanceof WanderingTraderEntity || entity instanceof SnowGolemEntity || entity instanceof PufferfishEntity)
        {

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
