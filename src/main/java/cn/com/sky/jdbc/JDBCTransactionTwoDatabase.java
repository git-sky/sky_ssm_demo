package cn.com.sky.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <pre>
 * 数据库连接是针对数据库实例的，如果一个数据库实例中有多个数据库，他们共享连接。
 * 所以事务也是针对数据库实例的，一个数据库实例中的多个数据库可以在一个事务下控制。
 */
public class JDBCTransactionTwoDatabase {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String USER = "root";
	public static final String PASSWD = "root";

	public static void update(int id, String name) {
		Connection conn = null;

		PreparedStatement pstmtupdate = null;

		PreparedStatement pstmtupdate2 = null;

		String updatesql = "update myjdbc.student set s_name='" + name + "' where s_id=" + id + "";
		String updatesql2 = "update mybatis.student set s_name='" + name + "' where s_id=" + id + "";

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWD);

			conn.setAutoCommit(false); // 自动提交设置为false

			// 执行更新操作
			pstmtupdate = conn.prepareStatement(updatesql);
			pstmtupdate.executeUpdate();

			// int a = 1 / 0;

			// 执行更新操作
			pstmtupdate2 = conn.prepareStatement(updatesql2);
			pstmtupdate2.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);

			pstmtupdate.close();
			pstmtupdate2.close();
			conn.close();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstmtupdate != null) {
					pstmtupdate.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {
			}
		}
	}

	public static void main(String args[]) {

		JDBCTransactionTwoDatabase.update(1, "f");
	}
}
