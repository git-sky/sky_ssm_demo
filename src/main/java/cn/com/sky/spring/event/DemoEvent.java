package cn.com.sky.spring.event;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String msg;

    public void sysLog() {
        System.out.println(msg);
    }

    public DemoEvent(Object source, String msg) {
        super(source);
        this.setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
