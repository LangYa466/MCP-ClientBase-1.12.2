package org.langya.clientbase.module.impl.move;

import com.cubk.event.annotations.EventTarget;
import org.langya.clientbase.event.impl.client.EventTick;
import org.langya.clientbase.module.Module;
import org.langya.clientbase.module.ModuleCategory;
import org.lwjgl.input.Keyboard;

/**
 * @author LangYa
 * @since 2024/07/08/下午5:01
 */
public class ModuleSprint extends Module {

    public ModuleSprint() {
        super("ModuleSprint", "Keep running", ModuleCategory.Move, Keyboard.KEY_V);
    }

    @EventTarget
    public void onTick(EventTick event) {
        mc.gameSettings.keyBindSprint.pressed = true;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.keyBindSprint.pressed = false;
    }
}
