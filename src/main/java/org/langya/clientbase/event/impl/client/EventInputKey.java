package org.langya.clientbase.event.impl.client;

import com.cubk.event.impl.Event;
import lombok.Getter;

/**
 * @author LangYa
 * @since 2024/07/08/下午5:44
 */
@Getter
public class EventInputKey implements Event {
    private int keyCode;

    public EventInputKey(int keyCode) {
        this.keyCode = keyCode;
    }

}
