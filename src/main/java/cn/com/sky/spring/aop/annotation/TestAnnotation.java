package cn.com.sky.spring.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 基于@AspectJ注解的AOP（注解AOP实现）
 * 
 */
public class TestAnnotation {

	private static String getPath() {
		String path = TestAnnotation.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/applicationContext.xml";

		final ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocation);
		UserDao userDao = (UserDao) appCtx.getBean("userDao");
		// userDao.add();
		// userDao.delete();
		// userDao.update("a");
		// userDao.update();
		// userDao.query();

		try {
			userDao.test();
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}
}