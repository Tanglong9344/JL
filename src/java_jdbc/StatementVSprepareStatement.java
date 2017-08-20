package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * PreparedStatement有预编译机制，性能比Statement更快
 */
public class StatementVSprepareStatement {
	public static void main(String[] args) {
		//加载驱动
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
			// Statement执行10次，需要10次把SQL语句传输到数据库端
			// 数据库要对每一次来的SQL语句进行编译处理
			final int N =10;//sql语句执行次数
			long start = System.currentTimeMillis();
			for (int i = 0; i < N; i++) {
				String sql0 = "insert into hero values(null,"
						+ "'提莫'" + ","+313.0f + "," + 50 + ")";
				s.execute(sql0);
			}
			long end = System.currentTimeMillis();
			System.out.printf("%s 执行 %d 次,共耗时%dms%n","Statement",N,(end-start));
			s.close();

			// PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
			// 数据库对带?的SQL进行预编译
			// 每次执行，只需要传输参数到数据库端
			// 1. 网络传输量比Statement更小
			// 2. 数据库不需要再进行编译，相应更快
			start = System.currentTimeMillis();
			for (int i = 0; i < N; i++) {
				ps.setString(1, "提莫");
				ps.setFloat(2, 313.0f);
				ps.setInt(3, 50);
				ps.execute();
			}
			end = System.currentTimeMillis();
			System.out.printf("%s 执行 %d 次,共耗时%dms%n","Statement",N,(end-start));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
