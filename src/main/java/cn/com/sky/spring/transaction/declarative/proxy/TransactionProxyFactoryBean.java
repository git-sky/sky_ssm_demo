package cn.com.sky.spring.transaction.declarative.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用TransactionProxyFactoryBean
 */
public class TransactionProxyFactoryBean {

	private static String getPath() {
		String path = TestProxyFactoryBean.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/allBeanOneProxy.xml";
		// String configLocation = getPath() + "/oneBeanOneProxy.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

		BookShopService bookShopService = (BookShopService) ctx.getBean("bookShopService");
		bookShopService.purchase("Lucy", "1001");
	}

}