package cn.com.sky.spring.beanfactory.programmatic;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import cn.com.sky.spring.beanfactory.programmatic.model.Account;
import cn.com.sky.spring.beanfactory.programmatic.model.Address;
import cn.com.sky.spring.beanfactory.programmatic.model.User;

/**
 * 1.直接编码方式
 */
public class TestByCode {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = (BeanFactory) bindViaCode(beanRegistry);
		User user = (User) container.getBean("user");
		user.say();
	}

	public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
		AbstractBeanDefinition user = new RootBeanDefinition(User.class, true);
		AbstractBeanDefinition account = new RootBeanDefinition(Account.class, true);
		AbstractBeanDefinition addr = new RootBeanDefinition(Address.class, true);
		// 将bean定义注册到容器中
		registry.registerBeanDefinition("user", user);
		registry.registerBeanDefinition("account", account);
		registry.registerBeanDefinition("addr", addr);

		// 指定依赖关系
		// 1. 可以通过构造方法注入方式
		ConstructorArgumentValues argValues = new ConstructorArgumentValues();
		argValues.addIndexedArgumentValue(0, account);
		argValues.addIndexedArgumentValue(1, addr);
		user.setConstructorArgumentValues(argValues);

		// 2. 或者通过setter方法注入方式
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("account", account));
		propertyValues.addPropertyValue(new PropertyValue("addr", addr));
		user.setPropertyValues(propertyValues);
		// 绑定完成 2
		return (BeanFactory) registry;
	}

}
