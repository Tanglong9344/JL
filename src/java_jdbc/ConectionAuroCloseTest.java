package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectionAuroCloseTest {
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
			//��������
			String sql = "insert into hero values(null," + "'��Ī'" + "," + 313.0f + "," + 50 + ")";
			s.execute(sql);
			System.out.println("�������ݳɹ�!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
