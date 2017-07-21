package cn.com.sky.spring.ioc.autoware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.ioc.annotation_autoware_full.TestAnnotationFull;

/**
 * <pre>
 * 
 * Spring提供了4种自动装配策略：
 * 
 * 类型		说明
 * no		默认方式，Bean的引用必须通过XML文件中的</ref>元素或者ref属性手动设定。
 * byName	把与Bean的属性具有相同名字（ID）的其他Bean自动装配到Bean对应属性中。如果没有跟属性的名字相匹配的Bean，则该属性不进行匹配。
 * byType	把与Bean的属性具有相同类型的其他Bean自动装配到Bean对应属性中。如果没有跟属性的类型相匹配的Bean，则该属性不进行匹配。
 * constructor	把与Bean的构造器入参具有相同类型的其他Bean自动装配到Bean构造器对应入中。
 * 
 * 
 * 
 * 测试Bean的自动装配-xml配置
 * 
 * </pre>
 */
public class TestXml {

	private static ApplicationContext context;
	private static Student stu;

	private static String getPath() {
		String path = TestXml.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		// context = new
		// ClassPathXmlApplicationContext(getPath() + "/byName.xml");
		// context = new
		// ClassPathXmlApplicationContext(getPath() + "/byType.xml");
		// context = new
		// ClassPathXmlApplicationContext(getPath() + "/byTypePrimary.xml");
		// context = new
		// ClassPathXmlApplicationContext(getPath() + "/byTypeCandidate.xml");
		// context = new
		// ClassPathXmlApplicationContext(getPath() + "/byConstructor.xml");

		context = new ClassPathXmlApplicationContext(getPath() + "/byDefault.xml");

		// 2. 从IOC容器中获取Bean实例
		stu = (Student) context.getBean("sky");
		// 3.调用方法
		System.out.println(stu);
		// 4.关闭容器
		((ClassPathXmlApplicationContext) context).registerShutdownHook();

	}
}