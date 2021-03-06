package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * connect to database 'mysql'
 *
 * @author tanglong
 *
 */
public class DriverManagerTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 建立与数据库的Connection连接
			// 这里需要提供：
			// 1. 数据库所处于的ip:127.0.0.1 (本机)
			// 2. 数据库的端口号： 3306 (mysql专用端口号)
			// 3. 数据库名称 test
			// 4. 编码方式 UTF-8
			// 5. 账号 root
			// 6. 密码 12345678
			Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8","root", "12345678");
			System.out.println("连接成功，获取连接对象： " + c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}