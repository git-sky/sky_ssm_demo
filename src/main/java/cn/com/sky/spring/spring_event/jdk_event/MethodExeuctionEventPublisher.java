package cn.com.sky.spring.spring_event.jdk_event;

import java.util.ArrayList;
import java.util.List;

public class MethodExeuctionEventPublisher {

    private List<MethodExecutionEventListener> listeners = new ArrayList<MethodExecutionEventListener>();

    public void methodToMonitor() {
        MethodExecutionEvent event2Publish = new MethodExecutionEvent(this, "methodToMonitor");
        publishEvent(MethodExecutionStatus.BEGIN, event2Publish);
        // TODO 执行实际的方法逻辑
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publishEvent(MethodExecutionStatus.END, event2Publish);
    }

    protected void publishEvent(MethodExecutionStatus status, MethodExecutionEvent methodExecutionEvent) {
        //为了避免事件处理期间事件监􏰃器的注册或移除操作影响处理过程，我们对事件发布时点的监􏰃器列表进行了一个安全复制(safe-copy)。
        List<MethodExecutionEventListener> copyListeners = new ArrayList<MethodExecutionEventListener>(listeners);

        for (MethodExecutionEventListener listener : copyListeners) {
            if (MethodExecutionStatus.BEGIN.equals(status)) {
                listener.onMethodBegin(methodExecutionEvent);
            } else {
                listener.onMethodEnd(methodExecutionEvent);
            }
        }
    }

    public void addMethodExecutionEventListener(MethodExecutionEventListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(MethodExecutionEventListener listener) {
        if (this.listeners.contains(listener)) {
            this.listeners.remove(listener);
        }
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    public static void main(String[] args) {
        MethodExeuctionEventPublisher eventPublisher = new MethodExeuctionEventPublisher();
        eventPublisher.addMethodExecutionEventListener(new SimpleMethodExecutionEventListener());
        eventPublisher.methodToMonitor();
    }
}
