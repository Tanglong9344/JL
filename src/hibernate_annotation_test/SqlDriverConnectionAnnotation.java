package hibernate_annotation_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@JDBCConfig(database="test",loginName="root",password="12345678")
public class SqlDriverConnectionAnnotation {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException, NoSuchMethodException, SecurityException {
		JDBCConfig config = SqlDriverConnectionAnnotation.class.getAnnotation(JDBCConfig.class);
 
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String loginName = config.loginName();
		String password = config.password();

		//×Ö·û´®¸ñÊ½»¯
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		return DriverManager.getConnection(url, loginName, password);
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
		Connection c = getConnection();
		System.out.println(c);
	}
}
