package cn.com.sky.spring.aop.annotation;

public interface UserDao {

    public void add();

    public void delete();

    public void update();

    public void update(String po);

    public String query();

    public void test() throws Exception;

}
