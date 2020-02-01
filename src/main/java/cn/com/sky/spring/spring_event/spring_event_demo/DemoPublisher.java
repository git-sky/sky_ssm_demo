package cn.com.sky.spring.spring_event.spring_event_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {

    @Autowired
    private ApplicationContext context;

    public void publish() {
        DemoEvent event = new DemoEvent(this, "发布成功！");
        System.out.println("发布event：" + event);
        context.publishEvent(event);
    }
}