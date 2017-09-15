package cn.com.sky.spring.applicationContext;

import org.springframework.context.ApplicationContext;

public class Test {

	private static String getPath() {
		String path = Test.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public static void main(String[] args) {

		String configLocation = getPath() + "/applicationContext.xml";

//		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		ApplicationContext context = new MyClassPathXmlApplicationContext(configLocation);

		// BeanFactory context = new XmlBeanFactory(new ClassPathResource(configLocation));

		Student sky1 = (Student) context.getBean("sky");
		// Student sky2 = (Student) context.getBean("sky");
		// Student sky3 = (Student) context.getBean("sky");
		//
		// System.out.println(sky1);
		// System.out.println(sky2);
		// System.out.println(sky3);

		// cn.com.sky.spring.applicationContext.Student@56a59355
		// cn.com.sky.spring.applicationContext.Student@56a59355
		// cn.com.sky.spring.applicationContext.Student@56a59355

		Student sky21 = (Student) context.getBean("sky2");
		// Student sky22 = (Student) context.getBean("sky2");
		// Student sky23 = (Student) context.getBean("sky2");
		//
		// System.out.println(sky21);
		// System.out.println(sky22);
		// System.out.println(sky23);

		// cn.com.sky.spring.applicationContext.Student@106bdde4
		// cn.com.sky.spring.applicationContext.Student@19b4ac28
		// cn.com.sky.spring.applicationContext.Student@24928347

		// Student sky3 = (Student) context.getBean("sky");
		// Student sky4 = (Student) context.getBean("sky2");
		// System.out.println(sky);
		// System.out.println(sky2);
		// System.out.println(sky3);
		// System.out.println(sky4);
		// System.out.println(sky == sky2);
		// System.out.println(sky == sky3);
		// System.out.println(sky2 == sky4);

	}
}
