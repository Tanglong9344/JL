package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PreparedStatement��Ԥ������ƣ����ܱ�Statement����
 */
public class StatementVSprepareStatement {
	public static void main(String[] args) {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "insert into hero values(null,?,?,?)";
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8","root", "12345678");
				Statement s = c.createStatement();
				PreparedStatement ps = c.prepareStatement(sql);) {
			// Statementִ��10�Σ���Ҫ10�ΰ�SQL��䴫�䵽���ݿ��
			// ���ݿ�Ҫ��ÿһ������SQL�����б��봦��
			final int N =10;//sql���ִ�д���
			long start = System.currentTimeMillis();
			for (int i = 0; i < N; i++) {
				String sql0 = "insert into hero values(null,"
						+ "'��Ī'" + ","+313.0f + "," + 50 + ")";
				s.execute(sql0);
			}
			long end = System.currentTimeMillis();
			System.out.printf("%s ִ�� %d ��,����ʱ%dms%n","Statement",N,(end-start));
			s.close();

			// PreparedStatement ִ��10�Σ�ֻ��Ҫ1�ΰ�SQL��䴫�䵽���ݿ��
			// ���ݿ�Դ�?��SQL����Ԥ����
			// ÿ��ִ�У�ֻ��Ҫ������������ݿ��
			// 1. ���紫������Statement��С
			// 2. ���ݿⲻ��Ҫ�ٽ��б��룬��Ӧ����
			start = System.currentTimeMillis();
			for (int i = 0; i < N; i++) {
				ps.setString(1, "��Ī");
				ps.setFloat(2, 313.0f);
				ps.setInt(3, 50);
				ps.execute();
			}
			end = System.currentTimeMillis();
			System.out.printf("%s ִ�� %d ��,����ʱ%dms%n","Statement",N,(end-start));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
