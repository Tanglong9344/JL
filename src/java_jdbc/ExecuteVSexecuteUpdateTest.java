package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteVSexecuteUpdateTest {
	public static void main(String[] args) {
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
				+ "test?characterEncoding=UTF-8","root", "12345678");
				Statement s = c.createStatement();) {
			String sqlInsert = "insert into Hero values (null,'盖伦',616,100)";
			String sqlDelete = "delete from Hero where id = 10";
			String sqlUpdate = "update Hero set hp = 300 where id = 10";
			String sqlSelect = "select * from hero";
			// 相同点：都可以执行增加，删除，修改
			//execute
			s.execute(sqlInsert);
			s.execute(sqlDelete);
			s.execute(sqlUpdate);
			//executeUpdate
			s.executeUpdate(sqlInsert);
			s.executeUpdate(sqlDelete);
			s.executeUpdate(sqlUpdate);

			// 不同1：execute可以执行查询语句
			// 然后通过getResultSet，把结果集取出来
			//execute
			s.execute(sqlSelect);
			ResultSet rs = s.getResultSet();
			System.out.println("execute 查询结果:");
			while (rs.next()) {
				System.out.println("Id:"+rs.getInt("id"));
			}

			// executeUpdate不能执行查询语句
			// s.executeUpdate(sqlSelect);
			// execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等

			// 不同2:
			// execute返回boolean类型，true表示执行的是查询语句
			//false表示执行的是insert,delete,update等等
			boolean isSelect = s.execute(sqlSelect);
			System.out.println("execute 执行select语句返回值:"+isSelect);

			// executeUpdate返回的是int，表示有多少条数据受到了影响
			String sqlUpdate2 = "update Hero set hp = 300 where id < 100";
			int number = s.executeUpdate(sqlUpdate2);
			System.out.println("executeUpdate 执行select语句返回值:"+number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
