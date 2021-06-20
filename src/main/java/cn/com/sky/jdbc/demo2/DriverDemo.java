package cn.com.sky.jdbc.demo2;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 */
public class DriverDemo {
    @Test
    public void testDriver() throws SQLException {

        //1. 创建一个 Driver 实现类的对象
        Driver driver = new com.mysql.jdbc.Driver();

        //2. 准备连接数据库的基本信息: url, user, password
        String url = "jdbc:mysql://127.0.0.1:3306/myjdbc";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "123456");

        //3. 调用 Driver 接口的　connect(url, info) 获取数据库连接
        Connection connection = driver.connect(url, info);
        System.out.println(connection);

    }
}