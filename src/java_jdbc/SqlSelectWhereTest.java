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
			//�û���
			String name = "user";
			//����
			String password = "123";
			String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
			// ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				System.out.println("�˺�������ȷ");
			} else {
				System.out.println("�˺��������");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}