package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlNoTransaction {
	public static void main(String[] args) {
		//��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8","root", "12345678");
				Statement s = c.createStatement();) {
			//û�������ǰ����
			//����ҵ�����ʱ����Ѫ����Ѫ����һ��
			//������Ӣ�۵�Ѫ������
			//��Ѫ��SQL
			String sql1 = "update hero set hp = hp +1 where id = 1";
			s.execute(sql1);
			//��Ѫ��SQL
			//��С��д��д���� updata(����update)
			String sql2 = "updata hero set hp = hp -1 where id = 22";
			s.execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}