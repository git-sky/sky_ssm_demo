package cn.com.sky.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JDBCOperation {

	private static Connection getConn() {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sql_learning";
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

	private static void insert(Order order) {

	}

	// private static int update(Student student) {
	// Connection conn = getConn();
	// int i = 0;
	// String sql = "update student set class_id=" + student.getClassId() + " where s_name='" +
	// student.getName() + "'";
	// PreparedStatement pstmt;
	// try {
	// pstmt = (PreparedStatement) conn.prepareStatement(sql);
	// i = pstmt.executeUpdate();
	// System.out.println("result: " + i);
	// pstmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return i;
	// }
	//
	// private static Integer getAll() {
	// Connection conn = getConn();
	// String sql = "select * from student";
	// PreparedStatement pstmt;
	// try {
	// pstmt = (PreparedStatement) conn.prepareStatement(sql);
	// ResultSet rs = pstmt.executeQuery();
	// int col = rs.getMetaData().getColumnCount();
	// System.out.println("============================");
	// while (rs.next()) {
	// for (int i = 1; i <= col; i++) {
	// System.out.print(rs.getString(i) + "\t");
	// if ((i == 2) && (rs.getString(i).length() < 8)) {
	// System.out.print("\t");
	// }
	// }
	// System.out.println("");
	// }
	// System.out.println("============================");
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// private static int delete(String name) {
	// Connection conn = getConn();
	// int i = 0;
	// String sql = "delete from student where s_name='" + name + "'";
	// PreparedStatement pstmt;
	// try {
	// pstmt = (PreparedStatement) conn.prepareStatement(sql);
	// i = pstmt.executeUpdate();
	// System.out.println("result: " + i);
	// pstmt.close();
	// conn.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return i;
	// }

	public static void main(String args[]) {
		Connection conn = getConn();
		try {
			conn.setAutoCommit(false);

			String sql = "insert into Orders (`orderid`, `customerid`, `employeeid`,`orderdate`) values(?,?,?,?)";
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

			// JDBCOperation.getAll();
			Random r = new Random();
			Date d = new Date();
			long time = d.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			int count=10000;
			for (int i = 0; i < 200000; i++) {
				Order order = new Order();
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < 5; j++) {
					int pos = r.nextInt(26) + 65;
					char c = (char) pos;
					sb.append(c);
				}

				int x = -r.nextInt(1944799597);
				d.setTime(time + x);

				order.setCustomerId(sb.toString());
				order.setEmployeeId(i);
				order.setOrderDate(d);
				order.setOrderId(i + count);

				pstmt.setInt(1, order.getOrderId());
				pstmt.setString(2, order.getCustomerId());
				pstmt.setInt(3, order.getEmployeeId());
				java.sql.Date sqlDate = new java.sql.Date(order.getOrderDate().getTime());
				pstmt.setDate(4, sqlDate);
				pstmt.addBatch();
			}
			// JDBCOperation.getAll();
			// JDBCOperation.update(new Student("Male", 33));
			// JDBCOperation.delete("Male");
			// JDBCOperation.getAll();
			pstmt.executeBatch();
			conn.commit();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}