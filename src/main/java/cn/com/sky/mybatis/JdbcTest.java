package cn.com.sky.mybatis;

import java.net.Socket;
import java.sql.*;


/**
 * <pre>
 * 原⽣使用jdbc查询数据DB的程序。
 *
 * 问题总结
 * 1. 数据库使⽤用时创建，不使⽤时立即释放，对数据库进行频繁的连接开启和关闭，造成数据库资源的浪费，影响数据库的性能。
 * 2. 将sql语句硬编码到java代码中，如果sql语句修改，就要重新编译java程序。
 * 3. 向preparedStatement中设置参数，对占位符位置和设置参数值，硬编码在java 代码中，不利于系统维护。
 * 4. 从resultSet结果集中遍历数据时，存在硬编码。
 *
 * </pre>
 */
public class JdbcTest {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
//            Socket socket=  new Socket();
//            socket.getInputStream();

            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8&connectTimeout=600000&socketTimeout=600000", "root", "123456");
            //定义sql语句 ?表示占位符
            String sql = "select * from user where user_name = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第⼆个参数为设置的参数值
            preparedStatement.setString(1, "zhangsan");
            //向数据库发出sql执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("user_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}