package java_effective_constructor;

/**
 * JavaBean ������
 * @author ����
 */
public class JavaBeanConstructorTest {
	public static void main(String[] args) {
		JavaBeanConstructor jb = new JavaBeanConstructor();
		// set name
		jb.setName("Tanglong");
		System.out.println(jb.toString());

		// set sex
		jb.setSex("��");
		System.out.println(jb.toString());

		// set age
		jb.setAge("18");
		System.out.println(jb.toString());

		// set address
		jb.setAddress("����");
		System.out.println(jb.toString());
	}
}