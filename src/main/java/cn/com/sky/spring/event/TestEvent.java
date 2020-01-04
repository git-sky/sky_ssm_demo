package cn.com.sky.spring.event;

import cn.com.sky.spring.applicationContext.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Properties;

public class TestEvent {


    private static String getPath() {
        String path = TestEvent.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }

    @SuppressWarnings({"deprecation", "unused"})
    public static void main(String[] args) {

        System.out.println(getPath());

        System.out.println(TestEvent.getPath());


        String configLocation = "cn\\com\\sky\\spring\\event\\applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
//        ApplicationContext ctx = new FileSystemXmlApplicationContext(configLocation);


        DemoPublisher publisher = ctx.getBean(DemoPublisher.class);
        publisher.publish();
        ((ClassPathXmlApplicationContext) ctx).close();
    }


}
