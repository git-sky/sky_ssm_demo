package cn.com.sky.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransaction {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/myjdbc";
	public static final String USER = "root";
	public static final String PASSWD = "root";

	public static void update(int id, String name) {
		Connection conn = null;

		PreparedStatement pstmtupdate = null;
		PreparedStatement pstmtquery = null;

		String updatesql = "update student set s_name='" + name + "' where s_id=" + id + "";

		String querysql = "select * from student";

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWD);

			conn.setAutoCommit(false); // 自动提交设置为false

			// 执行更新操作
			pstmtupdate = conn.prepareStatement(updatesql);
			pstmtupdate.executeUpdate();

			// 执行查找操作
			pstmtquery = conn.prepareStatement(querysql);
			pstmtquery.executeQuery();

			conn.commit();
			conn.setAutoCommit(true);

			pstmtupdate.close();
			pstmtquery.close();
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

				if (pstmtquery != null) {
					pstmtquery.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {
			}
		}
	}

	public static void main(String args[]) {

		JDBCTransaction.update(1, "namema");
	}
}
