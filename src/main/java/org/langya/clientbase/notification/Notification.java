package org.langya.clientbase.notification;
import lombok.Getter;
import lombok.val;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import org.langya.clientbase.Wrapper;
import org.langya.clientbase.util.Easing;
import org.langya.clientbase.util.EasingAnimation;

import java.awt.*;

/**
 * @author yuxiangll
 * @since 2024/1/8 04:58
 * IntelliJ IDEA
 */
@Getter
public class Notification implements Wrapper {
    private final String content;
    private final EasingAnimation animationX, animationY, animationProcess;
    private final NotificationType type;
    private final Color color;
    private final long begin_time, duration;
    private boolean initialized = false;
    private final float height = 20;

    public Notification(String content, Easing easingX, Easing easingY, long duration, NotificationType type) {
        this.content = content;
        this.animationX = new EasingAnimation(easingX, (long) (duration * 0.2), 0);
        this.animationY = new EasingAnimation(easingY, (long) (duration * 0.2), 0);
        this.animationProcess = new EasingAnimation(Easing.EASE_OUT_QUART, (long) (duration * 0.8), 0);
        this.type = type;
        switch (type) {
            case INIT:
                color = new Color(161, 161, 161);
                break;
            case SUCCESS:
                color = new Color(0, 255, 42);
                break;
            case FAILED:
                color = new Color(255, 0, 30);
                break;
            case WARNING:
                color = new Color(255, 251, 0);
                break;
            default:
                color = new Color(-1);
        }
        begin_time = System.currentTimeMillis();
        this.duration = duration;
    }

    public boolean isDone() {
        return System.currentTimeMillis() >= begin_time + duration;
    }

    public void render(ScaledResolution sr, int index) {
        val font = mc.fontRendererObj;

        float width = (float) (font.getStringWidth(content) + 5 * 2);
        float targetY = sr.getScaledHeight() - (height + 2) * (index + 1);
        if (!initialized) {
            animationX.setStartValue(sr.getScaledWidth());
            animationY.setStartValue(targetY);
            initialized = true;
        }
        float targetX = sr.getScaledWidth() - width - 2;
        if (System.currentTimeMillis() >= begin_time + duration * 0.8) {
            targetX = sr.getScaledWidth() + 2;
            animationX.setDuration((long) (duration * 0.2));
        }

        float x = (float) animationX.getValue(targetX), y = (float) animationY.getValue(targetY);
        Gui.drawRect2(x, y, width, height, new Color(0, 0, 0, 80).getRGB());
        Gui.drawRect2(x, y, width * animationProcess.getValue(1), height / 8, color.getRGB());
        font.drawString(content, (int) (x + 5), (int) (y + (height - font.FONT_HEIGHT) / 2), type == null ? 0 : -1);
    }
}