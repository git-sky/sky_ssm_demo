package cn.com.sky.spring.aop.aopconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于Schema的AOP
 */
public class TestAop {

	private static String getPath() {
		String path = TestAop.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/applicationContext2.xml";

		final ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocation);
		UserDao userDao = (UserDao) appCtx.getBean("userDao");
		// userDao.add();
		// userDao.delete();
		// userDao.update();
		// userDao.query();
		userDao.query("abc");
	}

}