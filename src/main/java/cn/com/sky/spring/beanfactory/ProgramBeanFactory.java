package cn.com.sky.spring.beanfactory;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import cn.com.sky.spring.beanfactory.factory_bean.Car;

public class ProgramBeanFactory {
	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource("applicationContext.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		Car car = factory.getBean("car", Car.class); // Message是自己写的测试类
		car.getBrand();
	}
}