package cn.com.sky.spring.ioc.factory_initial.static_factory;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.beanfactory.demo.TestCarFactoryBean;
import cn.com.sky.spring.ioc.factory_initial.HelloApi;

public class TestFactory {

	private static String getPath() {
		String path = TestFactory.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	@Test
	public void testInstantiatingBeanByStaticFactory() {

		String configLocation = getPath() + "/initial.xml";

		// 使用静态工厂方法
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(configLocation);
		HelloApi bean3 = beanFactory.getBean("bean3", HelloApi.class);
		bean3.sayHello();
	}
}