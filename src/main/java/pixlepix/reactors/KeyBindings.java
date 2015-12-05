package pixlepix.reactors;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by localmacaccount on 5/30/15.
 */
public class KeyBindings {

    public static KeyBinding jumpKeyBind;
    public static KeyBinding jumpDownKeyBind;

    public static void init() {
        jumpKeyBind = new KeyBinding("reactors.angelJump", Keyboard.KEY_UP, "reactors.keyBindCategory");
        jumpDownKeyBind = new KeyBinding("reactors.angelJumpDown", Keyboard.KEY_DOWN, "reactors.keyBindCategory");
        ClientRegistry.registerKeyBinding(jumpKeyBind);
        ClientRegistry.registerKeyBinding(jumpDownKeyBind);
    }
}
