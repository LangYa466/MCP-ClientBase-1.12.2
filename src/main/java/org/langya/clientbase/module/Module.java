package org.langya.clientbase.module;

import lombok.Getter;
import lombok.Setter;
import org.langya.clientbase.Client;
import org.langya.clientbase.Wrapper;
import org.langya.clientbase.notification.NotificationType;

/**
 * @author LangYa
 * @since 2024/07/08/下午4:57
 */
@Getter
@Setter
public class Module implements Wrapper {
    private String name;
    private String description;
    private ModuleCategory category;
    private String suffix;
    private int key;
    private boolean state;

    public Module(String name, ModuleCategory category) {
        this.name = name;
        this.category = category;
    }

    public Module(String name, ModuleCategory category, int key) {
        this.name = name;
        this.category = category;
        this.key = key;
    }

    public Module(String name, String description, ModuleCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Module(String name, String description, ModuleCategory category, int key) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.key = key;
    }

    public void onEnable() {}
    public void onDisable() {}

    public void setState(boolean state) {
        this.state = state;

        if (state) {
            onEnable();
            Client.INSTANCE.getNotificationManager().post(String.format("Enabled %s.",name), NotificationType.SUCCESS);
            Client.INSTANCE.getEventManager().register(this);
        } else {
            onDisable();
            Client.INSTANCE.getNotificationManager().post(String.format("Disabled %s.",name), NotificationType.FAILED);
            Client.INSTANCE.getEventManager().unregister(this);
        }
    }

    public void toggle() {
        setState(!state);
    }

}
