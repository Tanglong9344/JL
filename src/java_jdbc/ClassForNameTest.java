package java_jdbc;

public class ClassForNameTest {
	public static void main(String[] args) {
		// 初始化驱动
		try {
			// 驱动类com.mysql.jdbc.Driver
			// 就在 mysql-connector-java-5.0.8-bin.jar中
			// 如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
			//Class.forName("com.mysql.jdbc.Driver").newInstance();//JDK9已标位过时
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			System.out.println("数据库驱动加载成功 ！");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
