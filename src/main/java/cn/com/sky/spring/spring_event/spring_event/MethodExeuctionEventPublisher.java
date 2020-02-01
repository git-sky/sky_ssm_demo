package cn.com.sky.spring.spring_event.spring_event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * 发布者
 */
public class MethodExeuctionEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    public void methodToMonitor() {
        MethodExecutionEvent beginEvt = new MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.BEGIN);
        this.eventPublisher.publishEvent(beginEvt);
// 执行实际方法逻辑
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MethodExecutionEvent endEvt = new MethodExecutionEvent(this, "methodToMonitor", MethodExecutionStatus.END);
        this.eventPublisher.publishEvent(endEvt);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher appCtx) {
        this.eventPublisher = appCtx;
    }
}