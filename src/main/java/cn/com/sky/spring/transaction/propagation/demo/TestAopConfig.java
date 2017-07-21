package cn.com.sky.spring.transaction.propagation.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopConfig {

	private static String getPath() {
		String path = TestAopConfig.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) throws Exception {

		String configLocation = getPath() + "/aopconfig.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

		BookShopService bookShopService = ctx.getBean(BookShopService.class);
		bookShopService.purchase("Lucy", "1001");
	}

}