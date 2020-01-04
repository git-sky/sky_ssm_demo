package cn.com.sky.spring.httpinvoker;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:client.xml");

        HttpInvokerTestI httpInvokerTestI = (HttpInvokerTestI) ac.getBean("remoteService");
        System.out.println(httpInvokerTestI.getTestPo("abc"));
    }

}
