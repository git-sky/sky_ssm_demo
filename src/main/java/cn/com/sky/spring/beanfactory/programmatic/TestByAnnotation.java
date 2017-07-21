package cn.com.sky.spring.beanfactory.programmatic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 3.使用注解
 */
public class TestByAnnotation {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation.xml");
		User user = (User) ctx.getBean("user");
		user.say();
	}
}
