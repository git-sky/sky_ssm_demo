package cn.com.sky.spring.aop.aopconfig;

public interface UserDao {

    void add();

    void add(String str);

    void delete();

    void update();

    void query();

    String query(String retValue);

}
