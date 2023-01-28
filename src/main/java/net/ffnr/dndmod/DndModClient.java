package net.ffnr.dndmod;

import net.fabricmc.api.ClientModInitializer;
import net.ffnr.dndmod.event.KeyInputHandler;

public class DndModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        KeyInputHandler.register();
    }
}
