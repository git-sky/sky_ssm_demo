package cn.com.sky.spring.spring_event.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPubLisher {

    @Autowired
    private ApplicationContext applicationContext;

    //事件发布方法
    public void pushListener(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }

}