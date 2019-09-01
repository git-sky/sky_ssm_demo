package cn.com.sky.spring.spring_event.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StopWatch;

@Configuration
@ComponentScan("cn.com.sky.spring.spring_event.demo")
@EnableAsync
public class EventConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        //用注入的形式完成事件发布
        DemoPubLisher pushListener = context.getBean(DemoPubLisher.class);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("test");

        System.out.println("=========begin==================begin==================begin=========");


        for (int i = 0; i < 10000; i++) {
            try {
                pushListener.pushListener("test" + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("=========end==================end==================end=========");
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        context.close();
    }

}