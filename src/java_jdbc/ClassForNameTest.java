package java_jdbc;

public class ClassForNameTest {
	public static void main(String[] args) {
		// ��ʼ������
		try {
			// ������com.mysql.jdbc.Driver
			// ���� mysql-connector-java-5.0.8-bin.jar��
			// ��������˵�һ������ĵ������ͻ��׳�ClassNotFoundException
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("���ݿ��������سɹ� ��");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}