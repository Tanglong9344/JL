package java_effective_constructor;

/**
 * ²ãµþ¹¹ÔìÆ÷²âÊÔÀà
 * @author ÌÆÁú
 */
public class TelescopeConstructorTest {
	public static void main(String[] args) {
		TelescopeConstructor ts = null;
		ts = new TelescopeConstructor("Tanglong");
		System.out.println(ts.toString());

		ts = new TelescopeConstructor("Tanglong","ÄÐ");
		System.out.println(ts.toString());

		ts = new TelescopeConstructor("Tanglong","ÄÐ","18");
		System.out.println(ts.toString());

		ts = new TelescopeConstructor("Tanglong","ÄÐ","18","º¼ÖÝ");
		System.out.println(ts.toString());
	}
}