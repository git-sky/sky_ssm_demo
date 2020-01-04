package cn.com.sky.spring.jms.demo;

import javax.jms.Destination;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/com/sky/spring/jms/jms.xml");

        Destination destination = ac.getBean("queueDestination", Destination.class);
        ConsumerService consumerService = ac.getBean("consumerService", ConsumerService.class);

        consumerService.consumeMessage(destination);

    }

}