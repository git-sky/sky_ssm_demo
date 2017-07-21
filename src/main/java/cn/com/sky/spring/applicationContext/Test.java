package cn.com.sky.spring.applicationContext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	private static String getPath() {
		String path = Test.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/applicationContext.xml";

		// ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);

		BeanFactory context = new XmlBeanFactory(new ClassPathResource(configLocation));

		Student sky = (Student) context.getBean("sky");
		Student sky2 = (Student) context.getBean("sky2");
//		Student sky3 = (Student) context.getBean("sky");
//		Student sky4 = (Student) context.getBean("sky2");
//		System.out.println(sky);
//		System.out.println(sky2);
//		System.out.println(sky3);
//		System.out.println(sky4);
//		System.out.println(sky == sky2);
//		System.out.println(sky == sky3);
//		System.out.println(sky2 == sky4);

	}
}
