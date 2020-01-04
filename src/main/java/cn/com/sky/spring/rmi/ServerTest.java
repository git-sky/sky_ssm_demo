package cn.com.sky.spring.rmi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerTest {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("cn/com/sky/spring/rmi/rmi-server.xml");
    }

}
