package cn.com.sky.spring.orm.jdbc.template.datasource;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import cn.com.sky.spring.orm.jdbc.template.dao.UserDao;
import cn.com.sky.spring.orm.jdbc.template.model.User;

public class TestDataSource {

	private static String getPath() {
		String path = TestDataSource.class.getPackage().getName();
		String p = path.replaceAll("\\.", "/");
		System.out.println(p);
		return p;
	}

	public static void main(String[] args) {

		String configLocation = getPath() + "/applicationContext.xml";
		System.out.println(configLocation);

		final ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext(configLocation);
		UserDao userDao = (UserDao) appCtx.getBean("userDaoDynamic");

		List<User> list = userDao.find();
		for (User user2 : list) {
			System.out.println(user2);
		}

		// DriverManagerDataSource dmds = new DriverManagerDataSource();
		// SingleConnectionDataSource scds = new SingleConnectionDataSource();
		
//		DelegatingDataSource的子类
		// TransactionAwareDataSourceProxy
		// LazyConnectionDataSourceProxy

	}

}
