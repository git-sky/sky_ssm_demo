package cn.com.sky.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    /***
     * 对消息进行接受处理
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("DemoListener接受到了 DemoListener发布的消息：" + msg);
    }


}