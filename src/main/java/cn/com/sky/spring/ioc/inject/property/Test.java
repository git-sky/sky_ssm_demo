package cn.com.sky.spring.ioc.inject.property;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 属性注入
 */
public class Test {

	public static void main(String[] args) {
		
		String path = Test.class.getPackage().getName();
		path = path.replaceAll("\\.", "/");
		path = path + "/spring-property-student.xml";

		// ClassPathXmlApplicationContext：ApplicationContext实现，从classpath获取配置文件；
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext(path);

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
