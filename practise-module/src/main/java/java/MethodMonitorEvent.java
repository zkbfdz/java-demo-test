package java;

import java.util.EventObject;

/**
 * Created by kai.zhu on 2018/9/12/012.
 */
public class MethodMonitorEvent extends EventObject {

    public long timestamp;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MethodMonitorEvent(Object source) {
        super(source);
    }
}
