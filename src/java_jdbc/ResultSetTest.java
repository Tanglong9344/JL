package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {
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
			String sql = "select * from hero";
			// ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");// ����ʹ���ֶ���
				String name = rs.getString(2);// Ҳ����ʹ���ֶε�˳��
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				//��ʾ��ѯ���
				System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
			}
			// ��һ��Ҫ������ر�ReultSet����ΪStatement�رյ�ʱ�򣬻��Զ��ر�ResultSet
			// rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}