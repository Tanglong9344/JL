package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUpdateTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8",
				"root", "12345678");
				Statement s = c.createStatement();){
			String sql = "update hero set name = '巨灵神',hp="+800+",damage="+100+" where id = 3";
			System.out.println("数据更新成功!");
			s.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
