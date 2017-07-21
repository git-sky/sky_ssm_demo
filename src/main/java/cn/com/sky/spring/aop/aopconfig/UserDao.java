package cn.com.sky.spring.aop.aopconfig;

public interface UserDao {

	public void add();

	void add(String str);

	public void delete();

	public void update();

	public void query();

	public String query(String retValue);

}
