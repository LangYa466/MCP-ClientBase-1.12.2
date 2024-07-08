package org.langya.clientbase;

import com.cubk.event.EventManager;
import com.cubk.event.annotations.EventTarget;
import lombok.Data;
import org.langya.clientbase.event.impl.client.EventShutdown;
import org.langya.clientbase.module.ModuleManager;
import org.langya.clientbase.notification.NotificationManager;

/**
 * @author LangYa
 * @since 2024/07/08/下午4:44
 */
@Data
public class Client {
    public static final Client INSTANCE = new Client();
    private final String name = "ClientBase";
    private final String author = "LangYa,";

    private EventManager eventManager;
    private NotificationManager notificationManager;
    private ModuleManager moduleManager;

    public void initClient() {
        eventManager = new EventManager();
        notificationManager = new NotificationManager();
        moduleManager = new ModuleManager();
    }

    @EventTarget
    public void onShutdown(EventShutdown event) {
        // TODO something
    }

}

