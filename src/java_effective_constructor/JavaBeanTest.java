package java_effective_constructor;

/**
 * JavaBean ²âÊÔÀà
 * @author ÌÆÁú
 */
public class JavaBeanTest {
	public static void main(String[] args) {
		JavaBean jb = new JavaBean();
		// set name
		jb.setName("Tanglong");
		System.out.println(jb.toString());

		// set sex
		jb.setSex("ÄĞ");
		System.out.println(jb.toString());

		// set age
		jb.setAge("18");
		System.out.println(jb.toString());

		// set address
		jb.setAddress("º¼Öİ");
		System.out.println(jb.toString());
	}
}