package cn.com.sky.servlet.listener.Observer;

//事件（就是包装后的被监听对象）
public class Event {

    private Thief thief;

    public Event() {
    }

    public Event(Thief thief) {
        this.thief = thief;
    }

    public Thief getThief() {
        return thief;
    }

    public void setThief(Thief thief) {
        this.thief = thief;
    }
}