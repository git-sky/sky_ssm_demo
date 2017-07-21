package cn.com.sky.spring.ioc.factory_initial.instance_factory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.ioc.factory_initial.HelloApi;

public class TestFactory {

	private static String getPath() {
		String path = TestFactory.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	@Test
	public void testInstantiatingBeanByInstanceFactory() {
		String configLocation = getPath() + "/initial.xml";

		// 使用实例工厂方法
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(configLocation);
		HelloApi bean4 = beanFactory.getBean("bean4", HelloApi.class);
		bean4.sayHello();
	}
}