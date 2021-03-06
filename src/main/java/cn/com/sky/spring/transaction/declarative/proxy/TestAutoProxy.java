package cn.com.sky.spring.transaction.declarative.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用BeanNameAutoProxyCreator
 */
public class TestAutoProxy {

	private static String getPath() {
		String path = TestAutoProxy.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/autoProxy.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

		BookShopService bookShopService = (BookShopService) ctx.getBean("bookShopServiceTarget");

		bookShopService.purchase("Lucy", "1001");

		// CashierImpl cashier = (CashierImpl)ctx.getBean("cashier");
		// ArrayList<String> isbns = new ArrayList<String>();
		// isbns.add("1001");
		// cashier.checkout("Lucy", isbns);
	}

}