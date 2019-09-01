package cn.com.sky.spring.spring_event.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {

    //监听事件执行方法
    @Async
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("DemoEventListener,监听到了 DemoEvent 发布的消息:" + msg);
        //让线程睡眠是用来测试,监听者监听到发布者发布事件后,执行任务的时候

        if (msg.equals("test3")) {
            throw new RuntimeException("aaaaa");
        }
        //是否是同步执行
        if (msg.substring(0, 4).equals("test")) {
            try {
                Thread.sleep(2000);
                System.out.println("process " + event.getMsg() + "     over!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}