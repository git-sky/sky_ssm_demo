package cn.com.sky.spring.aop.aopconfig;

public class UserDaoImpl implements UserDao {

	@Override
	public void add() {
		System.out.println("add...");

	}

	@Override
	public void add(String str) {
		System.out.println("add:" + str);
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
	public String query(String retValue) {
		System.out.println("myquery....");
		return "myquery";
	}

}
