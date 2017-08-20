package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Statement需要进行字符串拼接，可读性和维修性比较差
 * String sql = "insert into hero values(null,"
 * + "'提莫'" + "," + 313.0f + "," + 50 + ")";
 * s.execute(sql);
 * PreparedStatement 使用参数设置，可读性好，不易犯错
 *  "insert into hero values(null,?,?,?)";
 */

public class PrepareStatementStatementTest {
	public static void main(String[] args) {
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "insert into hero values(null,?,?,?)";
		//与数据库建立连接
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8","root", "12345678");
				// 根据sql语句创建PreparedStatement
				PreparedStatement ps = c.prepareStatement(sql);) {
			// 设置参数
			ps.setString(1, "提莫");
			ps.setFloat(2, 313.0f);
			ps.setInt(3, 50);
			// 执行
			ps.execute();
			System.out.println("PreStatement 执行成功!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
