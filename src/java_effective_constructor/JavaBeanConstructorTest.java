package java_effective_constructor;

/**
 * JavaBean ≤‚ ‘¿‡
 * @author Ã∆¡˙
 */
public class JavaBeanConstructorTest {
	public static void main(String[] args) {
		JavaBeanConstructor jb = new JavaBeanConstructor();
		// set name
		jb.setName("Tanglong");
		System.out.println(jb.toString());

		// set sex
		jb.setSex("ƒ–");
		System.out.println(jb.toString());

		// set age
		jb.setAge("18");
		System.out.println(jb.toString());

		// set address
		jb.setAddress("∫º÷›");
		System.out.println(jb.toString());
	}
}