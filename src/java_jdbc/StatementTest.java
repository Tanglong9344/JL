package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager
					.getConnection(
							"jdbc:mysql://127.0.0.1:3306/test?"
									+ "characterEncoding=UTF-8",
									"root", "12345678");
			// 注意：使用的是 java.sql.Statement
			// 不要不小心使用到： com.mysql.jdbc.Statement;
			Statement s = c.createStatement();
			System.out.println("获取 Statement对象： " + s);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
