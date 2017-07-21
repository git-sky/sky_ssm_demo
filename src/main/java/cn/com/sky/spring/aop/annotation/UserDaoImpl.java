package cn.com.sky.spring.aop.annotation;

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
	public String query() {
		System.out.println("query...");
		return "myquery";
	}

	@Override
	public void test() throws Exception {
		System.out.println("test");
		throw new Exception("异常");
	}

	@Override
	public void update(String po) {
		System.out.println("update po ...");

	}

}
