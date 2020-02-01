package cn.com.sky.spring.spring_event.spring_event_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringEvent {


    private static String getPath() {
        String path = TestSpringEvent.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {

        String configLocation = getPath()+"/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

        DemoPublisher publisher = ctx.getBean(DemoPublisher.class);
        publisher.publish();
        ((ClassPathXmlApplicationContext) ctx).close();
    }


}
