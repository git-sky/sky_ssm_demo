package cn.com.sky.spring.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/com/sky/spring/rmi/rmi-client.xml");
		HelloRmiService hrs = ac.getBean("myClient", HelloRmiService.class);
		System.out.println(hrs.add(1, 2));
	}

}
