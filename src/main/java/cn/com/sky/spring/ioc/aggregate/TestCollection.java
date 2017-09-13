package cn.com.sky.spring.ioc.aggregate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.beanfactory.factory_bean.TestCarFactoryBean;

/**
 * spring 装配集合
 */
public class TestCollection {

	private static ApplicationContext beanFactory;

	private static String getPath() {
		String path = TestCollection.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/spring-list-set-map-props.xml";

		beanFactory = new ClassPathXmlApplicationContext(configLocation);

		// 1. Object getBean(String name) 根据名称返回一个Bean，客户端需要自己进行类型转换；
		Bookstore store = (Bookstore) beanFactory.getBean("china-pub");
		System.out.println("---------------------");
		store.listAllBook();
		System.out.println("---------------------");
		store.listAllTable();
		System.out.println("---------------------");
		store.listAllComputer();

	}
}
