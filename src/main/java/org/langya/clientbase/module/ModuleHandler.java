package org.langya.clientbase.module;

import com.cubk.event.annotations.EventTarget;
import org.langya.clientbase.Client;
import org.langya.clientbase.Wrapper;
import org.langya.clientbase.event.impl.client.EventInputKey;

/**
 * @author LangYa
 * @since 2024/07/08/下午5:43
 */
public class ModuleHandler implements Wrapper {

    @EventTarget
    public void onInputKey(EventInputKey event) {
        for (Module module : Client.INSTANCE.getModuleManager().getModules()) {
            if (module.getKey() == event.getKeyCode()) module.toggle();
        }
    }

}
