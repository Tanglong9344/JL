package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ���������ݿ��Connection����
			// ������Ҫ�ṩ��
			// ���ݿ������ڵ�ip:127.0.0.1 (����)
			// ���ݿ�Ķ˿ںţ� 3306 ��mysqlר�ö˿ںţ�
			// ���ݿ����� test
			// ���뷽ʽ UTF-8
			// �˺� root
			// ���� 12345678
			Connection c = DriverManager
					.getConnection(
							"jdbc:mysql://127.0.0.1:3306/test?"
									+ "characterEncoding=UTF-8",
									"root", "12345678");
			System.out.println("���ӳɹ�����ȡ���Ӷ��� " + c);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}