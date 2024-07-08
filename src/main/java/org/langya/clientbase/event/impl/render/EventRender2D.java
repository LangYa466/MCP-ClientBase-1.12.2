package org.langya.clientbase.event.impl.render;

import com.cubk.event.impl.Event;
import lombok.Getter;
import net.minecraft.client.gui.ScaledResolution;

/**
 * @author LangYa
 * @since 2024/07/08/下午5:40
 */
@Getter
public class EventRender2D implements Event {
    private float partialTicks;
    private ScaledResolution scaledresolution;

    public EventRender2D(float partialTicks, ScaledResolution scaledresolution) {
        this.partialTicks = partialTicks;
        this.scaledresolution = scaledresolution;
    }

}
