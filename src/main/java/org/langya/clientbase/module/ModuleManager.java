package org.langya.clientbase.module;

import lombok.Getter;
import org.langya.clientbase.Client;
import org.langya.clientbase.module.impl.move.ModuleSprint;
import org.langya.clientbase.module.impl.render.ModuleHUD;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LangYa
 * @since 2024/07/08/下午4:59
 */
@Getter
public class ModuleManager {
    private List<Module> modules;

    public ModuleManager() {
        modules = new ArrayList<>();
        Client.INSTANCE.getEventManager().register(new ModuleHandler());

        modules.add(new ModuleSprint());
        modules.add(new ModuleHUD());
    }

}
