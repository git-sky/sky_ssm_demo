package cn.com.sky.spring.ioc.java_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <pre>
 * 
 * 基于Java的配置
 * 
 * 在基于Spring的XML配置时，XML配置的根元素是来自Spring Bean命名空间的<beans>元素。
 * 而在基于Java配置里使用@Configuration注解的Java类，来代替XML配置中的<beans>元素。
 * 
 * 
 * 在Spring的Java配置中，通过声明方法引用一个Bean并不等于等于调用该方法。
 * 如果真这样，每次调用schoolBean()，都将得到该Bean的一个新的实例。
 * 通过使用@Bean注解标注schoolBean()方法，会告知Spring我们希望该方法定义的Bean要被注册进Spring的应用上下文中。
 * 因此，其他Bean的声明方法中运用这个方法时，Spring都会拦截该方法的调用，并尝试在应用上下文中查找该Bean，而不是让方法创建一个新的实例。
 * 
 * </pre>
 */
public class Test {

	private static ApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Student student = (Student) context.getBean("yoonaStudent");
		student.setName("yoona");
		student.setAge(24);
		System.out.println(student.toString());

	}
}