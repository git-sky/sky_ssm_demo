package cn.com.sky.spring.jms.net2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReceiverApp {
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext("springJMSConfiguration.xml", "springJMSReceiver.xml");
    }
}
