package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ORMTest {
	public static Hero get(int id) {
		Hero hero = null;
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8","root", "12345678");
				Statement s = c.createStatement();) {
			String sql = "select * from hero where id = " + id;
			ResultSet rs = s.executeQuery(sql);
			// 因为id是唯一的，ResultSet最多只能有一条记录
			// 所以使用if代替while
			if (rs.next()) {
				hero = new Hero();
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				hero.setName(name);
				hero.setHp(hp);
				hero.setDamage(damage);
				hero.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hero;
	}
	public static void main(String[] args) {
		Hero h = get(2);
		System.out.println(h.getName());
	}
}