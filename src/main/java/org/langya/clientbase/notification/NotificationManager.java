package org.langya.clientbase.notification;

import com.cubk.event.annotations.EventTarget;
import lombok.val;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.langya.clientbase.Client;
import org.langya.clientbase.event.impl.render.EventRender2D;
import org.langya.clientbase.util.Easing;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yuxiangll
 * @since 2024/1/8 04:59
 * IntelliJ IDEA
 */
@SuppressWarnings("unused")
public class NotificationManager {
    private final CopyOnWriteArrayList<Notification> notificationArrayList;

    public NotificationManager() {
        notificationArrayList = new CopyOnWriteArrayList<>();
        Client.INSTANCE.getEventManager().register(this);
    }

    public void clearAll() {
        notificationArrayList.clear();
    }

    public void post(Notification notification) {
        notificationArrayList.add(notification);
    }

    public void post(String text,NotificationType type) {
        notificationArrayList.add(new Notification(text, Easing.EASE_IN_OUT_QUAD,
                Easing.EASE_IN_OUT_QUAD,
                2500, type));
    }

    @EventTarget
    public void onRender(EventRender2D event) {
        val sr = new ScaledResolution(Minecraft.getMinecraft());
        int pre_size = notificationArrayList.size();
        for (int j = 0; j < pre_size; j++)
            for (int i = 0; i < notificationArrayList.size(); i++)
                if (notificationArrayList.get(i) != null && notificationArrayList.get(i).isDone()) {
                    notificationArrayList.remove(notificationArrayList.get(i));
                    i--;
                }
        for (int i = 0; i < notificationArrayList.size(); i++)
            notificationArrayList.get(i).render(sr, i);
    }

}