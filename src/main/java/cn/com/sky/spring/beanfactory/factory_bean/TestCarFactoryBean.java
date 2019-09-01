package cn.com.sky.spring.beanfactory.factory_bean;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class TestCarFactoryBean {

	private static String getPath() {
		String path = TestCarFactoryBean.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/car.xml";

		//1.ResourceLoader
		ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
		//2.Resource
		Resource resource = resourceLoader.getResource(configLocation);

		//31 XmlBeanDefinitionReader.loadBeanDefinitions(resource);
		//
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);

		// 获取Car实例
		Car car = (Car) beanFactory.getBean("car");
		System.out.println(car);

		Car car2 = (Car) beanFactory.getBean("car");
		System.out.println(car2);

		// 获取CarFactoryBean实例
		CarFactoryBean carFactoryBean = (CarFactoryBean) beanFactory.getBean("&car");
		System.out.println(carFactoryBean);
	}
}