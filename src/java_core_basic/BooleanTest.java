package java_core_basic;

/**
 * Java ²¼¶ûÀàÐÍ
 *
 * @author ÌÆÁú
 */
public class BooleanTest {
	public static void main(String[] args) {
		Boolean b1 = true;
		Boolean b2 = new Boolean(false);
		boolean b3 = true;
		System.out.println("b1:" + b1);
		System.out.println("b2:" + b2);
		System.out.println("b3:" + b3);
		System.out.println("Boolean.TRUE:" + Boolean.TRUE);
		System.out.println("Boolean.FALSE:" + Boolean.FALSE);

		System.out.println("Boolean.getBoolean(\"true\"):" + Boolean.getBoolean("true"));
		System.out.println("Boolean.getBoolean(\"0\"):" + Boolean.getBoolean("0"));
		System.out.println("Boolean.getBoolean(\"\"):" + Boolean.getBoolean(""));

		System.out.println("Boolean.getBoolean(\"true\"):" + Boolean.parseBoolean("true"));
		System.out.println("Boolean.getBoolean(\"truee\"):" + Boolean.parseBoolean("truee"));

		System.out.println("Boolean.valueOf(true):" + Boolean.valueOf(true));
		System.out.println("Boolean.valueOf(false):" + Boolean.valueOf(false));

		System.out.println("Boolean.valueOf(\"true\"):" + Boolean.valueOf("true"));
		System.out.println("Boolean.valueOf(\"truee\"):" + Boolean.valueOf("truee"));
	}
}