package java_effective_constructor;

/**
 * ²ãµþ¹¹ÔìÆ÷²âÊÔÀà
 * @author ÌÆÁú
 */
public class TelescopeStructorTest {
	public static void main(String[] args) {
		TelescopeStructor ts = null;
		ts = new TelescopeStructor("Tanglong");
		System.out.println(ts.toString());

		ts = new TelescopeStructor("Tanglong","ÄÐ");
		System.out.println(ts.toString());

		ts = new TelescopeStructor("Tanglong","ÄÐ","18");
		System.out.println(ts.toString());

		ts = new TelescopeStructor("Tanglong","ÄÐ","18","º¼ÖÝ");
		System.out.println(ts.toString());
	}
}