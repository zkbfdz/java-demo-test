package listener.java;

import java.util.EventListener;

/**
 * Created by kai.zhu on 2018/9/12/012.
 */
public interface MethodMonitorEventListener extends EventListener {

    /**
     * 处理方法执行之前发布的事件
     * @param event 事件
     */
    public void onMethodBegin(MethodMonitorEvent event);

    /**
     * 处理方法结束时发布的事件
     * @param event 事件
     */
    public void onMethodEnd(MethodMonitorEvent event);
}
