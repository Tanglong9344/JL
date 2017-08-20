package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Statement��Ҫ�����ַ���ƴ�ӣ��ɶ��Ժ�ά���ԱȽϲ�
 * String sql = "insert into hero values(null,"
 * + "'��Ī'" + "," + 313.0f + "," + 50 + ")";
 * s.execute(sql);
 * PreparedStatement ʹ�ò������ã��ɶ��Ժã����׷���
 *  "insert into hero values(null,?,?,?)";
 */

public class PrepareStatementStatementTest {
	public static void main(String[] args) {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "insert into hero values(null,?,?,?)";
		//�����ݿ⽨������
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8","root", "12345678");
				// ����sql��䴴��PreparedStatement
				PreparedStatement ps = c.prepareStatement(sql);) {
			// ���ò���
			ps.setString(1, "��Ī");
			ps.setFloat(2, 313.0f);
			ps.setInt(3, 50);
			// ִ��
			ps.execute();
			System.out.println("PreStatement ִ�гɹ�!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
