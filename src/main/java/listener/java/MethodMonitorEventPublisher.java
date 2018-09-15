package listener.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by kai.zhu on 2018/9/12/012.
 */
public class MethodMonitorEventPublisher {

    private List<MethodMonitorEventListener> listeners = new ArrayList<MethodMonitorEventListener>();

    public void methodMonitor() throws InterruptedException {
        MethodMonitorEvent event = new MethodMonitorEvent(this);
        publishEvent("begin", event);
        TimeUnit.SECONDS.sleep(5);
        publishEvent("end", event);
    }

    private void publishEvent(String status, MethodMonitorEvent event) {
        List<MethodMonitorEventListener> copyListeners = new ArrayList<MethodMonitorEventListener>();
        copyListeners.addAll(listeners);

        for (MethodMonitorEventListener copyListener : copyListeners) {
            if ("begin".equalsIgnoreCase(status)) {
                copyListener.onMethodBegin(event);
            } else {
                copyListener.onMethodEnd(event);
            }
        }
    }

    public void addEventListener(MethodMonitorEventListener listener) {
        this.listeners.add(listener);
    }

    public static void main(String[] args) throws InterruptedException {
        MethodMonitorEventPublisher publisher = new MethodMonitorEventPublisher();
        publisher.addEventListener(new AbstractMethodMonitorEventListener());
        publisher.addEventListener(new AbstractMethodMonitorEventListener());
        publisher.addEventListener(new AbstractMethodMonitorEventListener());
        publisher.methodMonitor();
    }
}
