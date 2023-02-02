package net.ffnr.dndmod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.ffnr.dndmod.util.IEntityDataSaver;
import net.ffnr.dndmod.util.XpData;
import net.minecraft.command.CommandRegistryAccess;
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

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("exp").then(CommandManager.literal("get").executes(GetXp::runGet)));
    }
}
