package listener.java;

/**
 * Created by kai.zhu on 2018/9/12/012.
 */
public class AbstractMethodMonitorEventListener implements MethodMonitorEventListener {
    @Override
    public void onMethodBegin(MethodMonitorEvent event) {
        event.timestamp = System.currentTimeMillis();
    }

    @Override
    public void onMethodEnd(MethodMonitorEvent event) {
        long duration = System.currentTimeMillis() - event.timestamp;
        System.out.println("耗时:" + duration);
    }
}
