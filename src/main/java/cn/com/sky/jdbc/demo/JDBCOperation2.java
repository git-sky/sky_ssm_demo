package cn.com.sky.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JDBCOperation2 {

    private static Connection getConn() {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sql_learning";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); // classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String args[]) {
        Connection conn = getConn();
        try {
            conn.setAutoCommit(false);

            String sql = "insert into t(`a`, `b`, `c`,`d`) values(?,?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);

            // JDBCOperation.getAll();
            Random r = new Random();
            for (int i = 0; i < 50000; i++) {

//				pstmt.setInt(1, r.nextInt(10));
//				pstmt.setInt(2, r.nextInt(10));
//				pstmt.setInt(3, r.nextInt(10));
//				pstmt.setInt(4, r.nextInt(10));

                pstmt.setInt(1, 200000);
                pstmt.setInt(2, 200000);
                pstmt.setInt(3, 200000);
                pstmt.setInt(4, 200000);

                pstmt.addBatch();
            }
            pstmt.executeBatch();
            conn.commit();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}