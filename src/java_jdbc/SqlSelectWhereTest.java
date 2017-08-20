package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlSelectWhereTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8",
				"root", "12345678");
				Statement s = c.createStatement();) {
			//用户名
			String name = "user";
			//密码
			String password = "123";
			String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
			// 执行查询语句，并把结果集返回给ResultSet
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				System.out.println("账号密码正确");
			} else {
				System.out.println("账号密码错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}