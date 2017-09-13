package cn.com.sky.spring.beanfactory.normal;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class Test {

	private static String getPath() {
		String path = Test.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String configLocation = getPath() + "/byName.xml";

		// 1.ResourceLoader
		ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
		// 2.Resource
		Resource resource = resourceLoader.getResource(configLocation);

		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);

		Student stu = (Student) beanFactory.getBean("sky");
		System.out.println(stu);
		Student stu2 = (Student) beanFactory.getBean("sky");
		System.out.println(stu2);

	}
}