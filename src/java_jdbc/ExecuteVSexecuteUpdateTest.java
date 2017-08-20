package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteVSexecuteUpdateTest {
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
			String sqlInsert = "insert into Hero values (null,'����',616,100)";
			String sqlDelete = "delete from Hero where id = 10";
			String sqlUpdate = "update Hero set hp = 300 where id = 10";
			String sqlSelect = "select * from hero";
			// ��ͬ�㣺������ִ�����ӣ�ɾ�����޸�
			//execute
			s.execute(sqlInsert);
			s.execute(sqlDelete);
			s.execute(sqlUpdate);
			//executeUpdate
			s.executeUpdate(sqlInsert);
			s.executeUpdate(sqlDelete);
			s.executeUpdate(sqlUpdate);

			// ��ͬ1��execute����ִ�в�ѯ���
			// Ȼ��ͨ��getResultSet���ѽ����ȡ����
			//execute
			s.execute(sqlSelect);
			ResultSet rs = s.getResultSet();
			System.out.println("execute ��ѯ���:");
			while (rs.next()) {
				System.out.println("Id:"+rs.getInt("id"));
			}

			// executeUpdate����ִ�в�ѯ���
			// s.executeUpdate(sqlSelect);
			// execute����boolean���ͣ�true��ʾִ�е��ǲ�ѯ��䣬false��ʾִ�е���insert,delete,update�ȵ�

			// ��ͬ2:
			// execute����boolean���ͣ�true��ʾִ�е��ǲ�ѯ���
			//false��ʾִ�е���insert,delete,update�ȵ�
			boolean isSelect = s.execute(sqlSelect);
			System.out.println("execute ִ��select��䷵��ֵ:"+isSelect);

			// executeUpdate���ص���int����ʾ�ж����������ܵ���Ӱ��
			String sqlUpdate2 = "update Hero set hp = 300 where id < 100";
			int number = s.executeUpdate(sqlUpdate2);
			System.out.println("executeUpdate ִ��select��䷵��ֵ:"+number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
