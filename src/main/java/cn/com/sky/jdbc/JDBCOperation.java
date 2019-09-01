package cn.com.sky.jdbc;

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
        String password = "123456";
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

    private static int insert(Student student) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into student (s_name,class_id) values(?,?)";
        PreparedStatement pstmt;
        try {
            pstmt =  conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getClassId());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    private static int update(Student student) {
        Connection conn = getConn();
        int i = 0;
        String sql = "update student set class_id=" + student.getClassId() + " where s_name='" + student.getName() + "'";
        PreparedStatement pstmt;
        try {
            pstmt =  conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("result: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    private static Integer getAll() {
        Connection conn = getConn();
        String sql = "select * from student";
        PreparedStatement pstmt;
        try {
            pstmt =  conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int delete(String name) {
        Connection conn = getConn();
        int i = 0;
        String sql = "delete from student where s_name='" + name + "'";
        PreparedStatement pstmt;
        try {
            pstmt =  conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("result: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String args[]) {
        JDBCOperation.getAll();
        JDBCOperation.insert(new Student("Male", 12));
        JDBCOperation.getAll();
        JDBCOperation.update(new Student("Male", 33));
        JDBCOperation.delete("Male");
        JDBCOperation.getAll();
    }

}