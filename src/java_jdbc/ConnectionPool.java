package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	List<Connection> cs = new ArrayList<Connection>();
	int size;
	//构造方法
	public ConnectionPool(int size) {
		this.size = size;
		init();
	}
	//连接池初始化
	public void init() {
		//这里恰恰不能使用try-with-resource的方式，因为这些连接都需要是"活"的，不要被自动关闭了
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for (int i = 0; i < size; i++) {
				Connection c = DriverManager
						.getConnection("jdbc:mysql://127.0.0.1:3306/"
								+ "test?characterEncoding=UTF-8", "root", "12345678");
				cs.add(c);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//获取连接
	public synchronized Connection getConnection() {
		while (cs.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection c = cs.remove(0);
		return c;
	}

	public synchronized void returnConnection(Connection c) {
		cs.add(c);
		this.notifyAll();
	}
}