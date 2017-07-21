package cn.com.sky.spring.aop.annotation.scan;

import org.springframework.stereotype.Service;

@Service("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("add...");

	}

	@Override
	public void delete() {
		System.out.println("delete...");

	}

	@Override
	public void update() {
		System.out.println("update...");

	}

	@Override
	public void query() {
		System.out.println("query...");
	}

	@Override
	public void test() throws Exception {
		// throw new Exception("aaaa");
	}

}
