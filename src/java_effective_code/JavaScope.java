package java_effective_code;

/**
 * ×÷ÓÃÓò in Java
 *
 * @author ÌÆÁú
 *
 */
public class JavaScope {
	public static void main(String[] args) {
		// local variable
		{
			String var = "Local1...";
			System.out.println("var: " + var);
		}

		// global variable
		String var = "Global...";
		System.out.println("var: " + var);

		// local variable
		{
			//String var = "Local2...";
			System.out.println("var: " + var);
		}
	}
}