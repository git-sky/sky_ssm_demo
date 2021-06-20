package cn.com.sky.servlet.listener.Observer;


/**
 * 监听器的底层原理其实涉及到一种设计模式：观察者模式（Observer）。
 */
public class ObserverTest {
    public static void main(String[] args) {
        // 被监听对象
        Thief thief = new Thief();

        // 监听器，直接new一个接口的匿名类对象
        ThiefListener thiefListener = new ThiefListener() {
            public void shot(Event event) {
                System.out.println("啪啪啪！！！！");
            }
        };

        // 注册监听
        thief.registerListener(thiefListener);

        // 特定行为，触发监听器：内部调用listener.shot()
        thief.steal();
    }
}