package cn.com.sky.spring.transaction.programmatic.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.transaction.programmatic.api.service.BookShopService;

public class TestTx {

	private static String getPath() {
		String path = TestTx.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/spring_transaction.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

		BookShopService bookShopService = ctx.getBean(BookShopService.class);

		bookShopService.purchase("Lucy", "1001");
	}
}
