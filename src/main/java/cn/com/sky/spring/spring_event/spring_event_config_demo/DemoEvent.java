package cn.com.sky.spring.spring_event.spring_event_config_demo;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

    //事件监听消息
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}