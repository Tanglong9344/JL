package java_effective_constructor;

/**
 * ���������������
 * @author ����
 */
public class TelescopeStructorTest {
	public static void main(String[] args) {
		TelescopeStructor ts = null;
		ts = new TelescopeStructor("Tanglong");
		System.out.println(ts.toString());

		ts = new TelescopeStructor("Tanglong","��");
		System.out.println(ts.toString());

		ts = new TelescopeStructor("Tanglong","��","18");
		System.out.println(ts.toString());

		ts = new TelescopeStructor("Tanglong","��","18","����");
		System.out.println(ts.toString());
	}
}