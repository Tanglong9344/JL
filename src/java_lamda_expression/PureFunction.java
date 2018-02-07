package java_lamda_expression;

/**
 * Pure Function
 *
 * A pure function is a function whose (1.)return value is only
 * determined by its input, (2.)without observable side effects.
 * (3.)If we call it with the same parameters <code>n</code> times,
 * we are going to get the same result every single time.
 *
 * <bold>side-effects</bold>:
 * A side-effect is any possible observable output the function can produce,
 * for example, triggering events and throwing exceptions and I/O, different
 * from its return value. A side-effect also changes shared states or mutable
 * arguments.
 *
 * <bold>idempotence</bold>:
 * In computing, an idempotent operation is one that has no additional
 * effect if it is called more than once with the same input parameters;
 * in mathematics, an idempotent operation is one that satisfies this
 * expression:f(f(x)) = f(x)
 *
 * Idempotent function don't depend on time, so they can
 * treat continuous data as infinite data streams
 *
 * @author ÌÆÁú
 *
 */
public class PureFunction {
	public static void main(String[] args) throws Exception {
		int n = 10;
		int a=3, b=5;
		while((n--)>0) {
			System.out.println("Result: " + add(a, b));
		}
	}

	/**A pure function that calculate the sum of two numbers*/
	private static int add(int a, int b) {
		return a + b;
	}
}