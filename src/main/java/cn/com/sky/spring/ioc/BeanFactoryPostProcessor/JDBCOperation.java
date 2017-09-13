package cn.com.sky.spring.ioc.BeanFactoryPostProcessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOperation {

	private static Connection getConn() {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/myjdbc";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static ResultSet getProperties() {
		Connection conn = getConn();
		String sql = "select t.property_key, t.property_value from t_config_properties t ";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}