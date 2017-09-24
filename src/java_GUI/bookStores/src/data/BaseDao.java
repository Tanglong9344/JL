package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	protected static String driver = "com.mysql.jdbc.Driver"; // ���ݿ�����
	protected static String url = "jdbc:mysql://localhost:3306/bookstoresdb"; // ����url
	protected static String dbUser = "root"; // ���ݿ��û���
	protected static String dbPwd = "12345678"; // ���ݿ�����
	private static Connection conn = null;
	// ���췽�����������ݿ�����
	private BaseDao() {
		try {
			if (conn == null) {
				Class.forName(driver); // �������ݿ�����
				conn = DriverManager.getConnection(url, dbUser, dbPwd); // �������ݿ�����
			} else {
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ִ�����ݿ��ѯ����
	public static ResultSet executeQuery(String sql) {
		try {
			if (conn == null) {
				new BaseDao();
			}
			return conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(sql); // ִ�����ݿ��ѯ
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// ִ�����ݿ���²���
	public static int executeUpdate(String sql) {
		try {
			if (conn == null) {
				new BaseDao();
			}
			return conn.createStatement().executeUpdate(sql); // ִ�����ݿ����
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		} finally {}
	}

	//���ӹر�
	public static void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}