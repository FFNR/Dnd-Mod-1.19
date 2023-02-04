package net.ffnr.dndmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.ffnr.dndmod.command.GetXp;
import net.ffnr.dndmod.command.Level;
import net.ffnr.dndmod.event.OnDeathEntityHandler;
import net.ffnr.dndmod.items.DndItems;
import net.ffnr.dndmod.networking.ModMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DndMod implements ModInitializer {
	public static final String MOD_ID = "dndmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		DndItems.registerModItems();
		ModMessages.registerC2SPackets();

		ServerLivingEntityEvents.AFTER_DEATH.register(new OnDeathEntityHandler());
		CommandRegistrationCallback.EVENT.register(GetXp::register);
		CommandRegistrationCallback.EVENT.register(Level::register);
	}


}
