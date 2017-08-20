package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlNoTransaction {
	public static void main(String[] args) {
		//驱动加载
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8","root", "12345678");
				Statement s = c.createStatement();) {
			//没有事务的前提下
			//假设业务操作时，加血，减血各做一次
			//结束后，英雄的血量不变
			//加血的SQL
			String sql1 = "update hero set hp = hp +1 where id = 1";
			s.execute(sql1);
			//减血的SQL
			//不小心写错写成了 updata(而非update)
			String sql2 = "updata hero set hp = hp -1 where id = 22";
			s.execute(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}