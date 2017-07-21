package cn.com.sky.spring.beanfactory.programmatic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * 2.a>加载Properties配置的BeanFactory的使用
 */
public class TestByPropertiesFile {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = (BeanFactory) bindViaPropertiesFile(beanRegistry);
		User user = (User) container.getBean("user");
		user.say();
	}

	public static BeanFactory bindViaPropertiesFile(BeanDefinitionRegistry registry) {
		PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(registry);
		reader.loadBeanDefinitions("classpath:../../config.properties");
		return (BeanFactory) registry;
	}

}
