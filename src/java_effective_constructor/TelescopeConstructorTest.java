package java_effective_constructor;

/**
 * ���������������
 * @author ����
 */
public class TelescopeConstructorTest {
	public static void main(String[] args) {
		TelescopeConstructor ts = null;
		ts = new TelescopeConstructor("Tanglong");
		System.out.println(ts.toString());

		ts = new TelescopeConstructor("Tanglong","��");
		System.out.println(ts.toString());

		ts = new TelescopeConstructor("Tanglong","��","18");
		System.out.println(ts.toString());

		ts = new TelescopeConstructor("Tanglong","��","18","����");
		System.out.println(ts.toString());
	}
}