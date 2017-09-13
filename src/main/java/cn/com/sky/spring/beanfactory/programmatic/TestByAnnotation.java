package cn.com.sky.spring.beanfactory.programmatic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.beanfactory.factory_bean.TestCarFactoryBean;
import cn.com.sky.spring.beanfactory.programmatic.model.User;

/**
 * 3.使用注解
 */
public class TestByAnnotation {

	private static String getPath() {
		String path = TestByAnnotation.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/annotation.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		User user = (User) ctx.getBean("user");
		user.say();
	}
}
