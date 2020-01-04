package cn.com.sky.spring.jms.demo;

import javax.jms.Destination;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("cn/com/sky/spring/jms/jms.xml")
public class ProducerConsumerTest {

    // @Autowired
    // private ProducerService producerService;
    // @Autowired
    // @Qualifier("queueDestination")
    // private Destination destination;

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("cn/com/sky/spring/jms/jms.xml");

        ProducerService producerService = ac.getBean("producerService", ProducerService.class);
        Destination destination = ac.getBean("queueDestination", Destination.class);

        for (int i = 0; i < 10; i++) {
            producerService.sendMessage(destination, "你好，我是生产者！这是消息：" + (i + 1));
        }

    }

    // @Test
    // public void testSend() {
    // for (int i = 0; i < 2; i++) {
    // producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i + 1));
    // }
    // }

}