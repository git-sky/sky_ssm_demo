package cn.com.sky.spring.spring_event.spring_event;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPublisher {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(getPath() + "/applicationContext.xml");

        MethodExeuctionEventPublisher publisher = (MethodExeuctionEventPublisher) applicationContext.getBean("evtPublisher");
        publisher.methodToMonitor();
    }

    private static String getPath() {
        String path = TestPublisher.class.getPackage().getName();
        String p = path.replaceAll("\\.", "/");
        System.out.println(p);
        return p;
    }
}