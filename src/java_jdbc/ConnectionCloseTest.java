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
			//��������
			String sql = "insert into hero values(null," + "'������'" + "," + 313.0f + "," + 50 + ")";
			s.execute(sql);
			System.out.println("�������ݳɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ���ݿ������ʱ������Դ����ز������������ɹر����ݿ�ĺ�ϰ��
			// �ȹر�Statement
			if (s != null) {
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// ��ر�Connection
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