package net.ffnr.dndmod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.ffnr.dndmod.util.IEntityDataSaver;
import net.ffnr.dndmod.util.XpData;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class Level {

   /* public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated){
        dispatcher.register(CommandManager.literal("xp").then(CommandManager.literal("get").executes(GetXp::runGet)));
    }
*/
    private static int runGet(CommandContext<ServerCommandSource> context) throws CommandSyntaxException{
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
        ServerPlayerEntity p = (ServerPlayerEntity)context.getSource().getPlayer() ;
        p.sendMessage(Text.literal("Level: " + XpData.getLevel(player)));
        return 1;
    }

    private static int runReset(CommandContext<ServerCommandSource> context) throws CommandSyntaxException{
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();
        ServerPlayerEntity p = (ServerPlayerEntity)context.getSource().getPlayer() ;
        XpData.clearLevel(player);
        p.sendMessage(Text.literal("Reset Level to 0"));
        return 2;
    }
    private static int runSet(ServerCommandSource context, int amount) throws CommandSyntaxException{
        IEntityDataSaver player = (IEntityDataSaver)context.getPlayer();
        ServerPlayerEntity p = (ServerPlayerEntity)context.getPlayer() ;
        XpData.setLevel(player, amount);
        p.sendMessage(Text.literal("Set Level to: " + amount));
        return 3;
    }
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {

        dispatcher.register(CommandManager.literal("lvl").then(CommandManager.literal("get").executes(Level::runGet)));
        dispatcher.register(CommandManager.literal("lvl").then(CommandManager.literal("reset").executes(Level::runReset)));
        dispatcher.register(CommandManager.literal("lvl").then(CommandManager.literal("set").then(CommandManager.argument("amount", IntegerArgumentType.integer(1, 20))).executes(context -> runSet(context.getSource(), IntegerArgumentType.getInteger(context, "amount")))));

    }

}
