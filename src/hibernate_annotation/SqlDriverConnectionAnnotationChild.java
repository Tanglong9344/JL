/**
 * 子类可以继承父类的注解
 */

package hibernate_annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDriverConnectionAnnotationChild extends SqlDriverConnectionAnnotation {
	public static Connection getConnection() throws SQLException, NoSuchMethodException, SecurityException {
		JDBCConfig config = SqlDriverConnectionAnnotationChild.class.getAnnotation(JDBCConfig.class);
 
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String loginName = config.loginName();
		String password = config.password();

		//字符串格式化
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		return DriverManager.getConnection(url, loginName, password);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
		Connection c = getConnection();
		System.out.println(c);
	}
}
