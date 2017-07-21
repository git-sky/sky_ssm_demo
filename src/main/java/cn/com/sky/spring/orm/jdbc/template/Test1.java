package cn.com.sky.spring.orm.jdbc.template;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sky.spring.orm.jdbc.template.dao.UserDao;
import cn.com.sky.spring.orm.jdbc.template.model.User;

public class Test1 {
	@Test
	public void testAdd() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = new User();
		user.setName("spring");
		user.setPassword("spring");

		UserDao dao = (UserDao) ac.getBean("userDao");
		dao.add(user);
	}

	@Test
	public void testFind() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = (UserDao) ac.getBean("userDao");
		List<User> list = dao.find();
		for (User user : list) {
			System.out.println(user.getId() + ":" + user.getName() + ":" + user.getPassword());
		}

	}

	@Test
	public void testFindById() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = (UserDao) ac.getBean("userDao");
		User user = dao.findById("5");
		System.out.println(user.getId() + ":" + user.getName() + ":" + user.getPassword());
	}

	@Test
	public void testUpdate() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = (UserDao) ac.getBean("userDao");
		User user = dao.findById("5");
		user.setName("Spring3");
		dao.update(user);
	}

	@Test
	public void testDelete() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = (UserDao) ac.getBean("userDao");
		dao.delete("6");
	}
}
