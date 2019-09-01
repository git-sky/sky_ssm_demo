package cn.com.sky.spring.ioc.inject.constructor;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 构造方法注入
 */
public class TestConstructor {

	public static void main(String[] args) {

		String path = TestConstructor.class.getPackage().getName();
		path = path.replaceAll("\\.", "/");
		path = path + "/spring-constructor-student.xml";

		// ClassPathXmlApplicationContext：ApplicationContext实现，从classpath获取配置文件；
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext(path);

		// FileSystemXmlApplicationContext：ApplicationContext实现，从文件系统获取配置文件。
		// ApplicationContext beanFactory = new FileSystemXmlApplicationContext(path);

		// ApplicationContext接口获取Bean方法:
		// 1. Object getBean(String name) 根据名称返回一个Bean，客户端需要自己进行类型转换；
		// Student attack = (Student) beanFactory.getBean("student");

		// 2. T getBean(String name, Class<T> requiredType)
		// 根据名称和指定的类型返回一个Bean，客户端无需自己进行类型转换，如果类型转换失败，容器抛出异常；
		// Student attack = beanFactory.getBean("student", Student.class);

		// 3. T getBean(Class<T> requiredType)
		// 根据指定的类型返回一个Bean，客户端无需自己进行类型转换，如果没有或有多于一个Bean存在容器将抛出异常；
		// Student attack = beanFactory.getBean(Student.class);

		// 4. Map<String, T> getBeansOfType(Class<T> type) 根据指定的类型返回一个键值为名字和值为Bean对象的
		// Map，如果没有Bean对象存在则返回空的Map。
		Map<String, Student> map = beanFactory.getBeansOfType(Student.class);
		Iterator<Entry<String, Student>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			System.out.println("------------------------------");
			Entry<String, Student> entry = iter.next();
			String key = entry.getKey();
			Student s = entry.getValue();
			System.out.println(key);
			System.out.println(s);
		}
	}
}
