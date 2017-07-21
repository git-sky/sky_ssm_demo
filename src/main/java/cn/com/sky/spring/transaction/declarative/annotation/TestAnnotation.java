package cn.com.sky.spring.transaction.declarative.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

	private static String getPath() {
		String path = TestAnnotation.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/annotation.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
		BookShopService bookShopService = (BookShopService) ctx.getBean("bookShopService");
		bookShopService.purchase("Lucy", "1001");

	}
}