package org.langya.clientbase.module.impl.render;

import com.cubk.event.annotations.EventTarget;
import org.langya.clientbase.Client;
import org.langya.clientbase.event.impl.render.EventRender2D;
import org.langya.clientbase.module.Module;
import org.langya.clientbase.module.ModuleCategory;
import org.lwjgl.input.Keyboard;

/**
 * @author LangYa
 * @since 2024/07/08/下午5:37
 */
public class ModuleHUD extends Module {

    public ModuleHUD() {
        super("HUD", ModuleCategory.Render, Keyboard.KEY_H);
    }

    @EventTarget
    public void onRender2D(EventRender2D event) {
        mc.fontRendererObj.drawStringWithShadow(Client.INSTANCE.getName(),0,0,-1);
    }

}
