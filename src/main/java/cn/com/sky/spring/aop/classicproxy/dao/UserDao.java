package cn.com.sky.spring.aop.classicproxy.dao;

public interface UserDao {

	public void add();

	public void delete();

	public void update();

	public void query();

	public void test() throws Exception;

	String query(String id);

}
