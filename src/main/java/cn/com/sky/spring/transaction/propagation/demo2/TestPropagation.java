package cn.com.sky.spring.transaction.propagation.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPropagation {

	private static String getPath() {
		String path = TestPropagation.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) throws Exception {

		String configLocation = getPath() + "/spring.xml";

		ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

		TransactionAction action = ctx.getBean(TransactionAction.class);
		action.actionA();
	}

}