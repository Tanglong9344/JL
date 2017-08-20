package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionCloseTest {
	public static void main(String[] args) {
		Connection c = null;
		Statement s = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?"
					+ "characterEncoding=UTF-8"
					, "root","12345678");
			s = c.createStatement();
			//插入数据
			String sql = "insert into hero values(null," + "'阿拉丁'" + "," + 313.0f + "," + 50 + ")";
			s.execute(sql);
			System.out.println("插入数据成功!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
			// 先关闭Statement
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// 后关闭Connection
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}