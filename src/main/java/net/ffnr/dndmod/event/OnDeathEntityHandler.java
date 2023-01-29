package net.ffnr.dndmod.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.ffnr.dndmod.dnd.Character;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public class OnDeathEntityHandler implements ServerLivingEntityEvents.AfterDeath{

    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {

        if(entity instanceof CowEntity || entity instanceof SheepEntity || entity instanceof PigEntity || entity instanceof HorseEntity){

            Character.changeExperience(10);

        }



    }
}
