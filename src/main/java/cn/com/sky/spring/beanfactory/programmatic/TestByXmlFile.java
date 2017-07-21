package cn.com.sky.spring.beanfactory.programmatic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 2.b>加载xml配置文件的BeanFactory的使用
 */
public class TestByXmlFile {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = (BeanFactory) bindViaXmlFile(beanRegistry);
		User user = (User) container.getBean("user");
		user.say();
	}

	public static BeanFactory bindViaXmlFile(BeanDefinitionRegistry registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions("classpath:../config.xml");
		return (BeanFactory) registry;
		// 或者直接
		// return new XmlBeanFactory(new ClassPathResource("../config.xml"));
	}
}
