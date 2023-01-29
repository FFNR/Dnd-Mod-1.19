package net.ffnr.dndmod.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.ffnr.dndmod.dnd.Character;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_DND = "key.category.dndmod.dnd";
    public static final String KEY_MAIN_UI = "key.dndmod.main_ui";

    public static KeyBinding main_ui;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (main_ui.wasPressed())
            {
                int x = Character.getExperience();

                client.player.sendMessage(Text.of(Integer.toString(x)));
            }
        });
    }

    public static void register(){
        main_ui = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_MAIN_UI,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_U,
                KEY_CATEGORY_DND
        ));

        registerKeyInputs();
    }

}
