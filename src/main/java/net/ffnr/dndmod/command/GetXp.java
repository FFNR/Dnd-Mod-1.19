package net.ffnr.dndmod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.ffnr.dndmod.util.IEntityDataSaver;
import net.ffnr.dndmod.util.XpData;
import net.minecraft.client.realms.Request;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.RegistryEntryArgumentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class GetXp {

   /* public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated){
        dispatcher.register(CommandManager.literal("xp").then(CommandManager.literal("get").executes(GetXp::runGet)));
    }
*/
    private static int runGet(CommandContext<ServerCommandSource> context) throws CommandSyntaxException{
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
        ServerPlayerEntity p = (ServerPlayerEntity)context.getSource().getPlayer() ;
        p.sendMessage(Text.literal("XP: " + XpData.getExperience(player)));
        return 1;
    }

    private static int runReset(CommandContext<ServerCommandSource> context) throws CommandSyntaxException{
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
        ServerPlayerEntity p = (ServerPlayerEntity)context.getSource().getPlayer() ;
        XpData.clearExperience(player);
        p.sendMessage(Text.literal("Reset XP to 0"));
        return 2;
    }
    private static int runSet(ServerCommandSource context, int amount) throws CommandSyntaxException{
        IEntityDataSaver player = (IEntityDataSaver)context.getPlayer();
        ServerPlayerEntity p = (ServerPlayerEntity)context.getPlayer() ;
        XpData.setExperience(player, amount);
        p.sendMessage(Text.literal("Set XP to: " + amount));
        return 3;
    }

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("exp").then(CommandManager.literal("get").executes(GetXp::runGet)));
        dispatcher.register(CommandManager.literal("exp").then(CommandManager.literal("reset").executes(GetXp::runReset)));
        dispatcher.register(CommandManager.literal("exp").then(CommandManager.literal("set").then(CommandManager.argument("amount", IntegerArgumentType.integer())).executes(context -> runSet(context.getSource(), IntegerArgumentType.getInteger(context, "amount")))));



    }

}
