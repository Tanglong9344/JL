package java_lamda_expression;

import io.reactivex.functions.Function;

/**
 * Higher order function
 *
 * A function with at least one parameter of
 * type function or a function that return functions
 *
 * @author ÌÆÁú
 *
 */
public class HigherOrderFunction {
	public static void main(String[] args) throws Exception {
		// higher order function test1
		Function<Integer, Integer> fun = (v)->(Math.abs(v));
		System.out.println("Result: " + highSum(fun, fun, -1, 1));
		System.out.println("Result: " + highSum((v)->(v*v), (v)->(v*v*v), 3, 2));
		// higher order function test2
		String str = strJoint("Hello").apply("higher order function");
		System.out.println("Result: " + str);

		Function<String, String> f = strJoint("How are you?");
		System.out.println(f.apply("Tanglong"));
		System.out.println(f.apply("tl9344@126.com"));
	}
	/** A higher order function that receives functions*/
	public static <T, R> int highSum(Function<T, Integer> f1,Function<R, Integer> f2, T data1, R data2) throws Exception {
		return f1.apply(data1) + f2.apply(data2);
	}

	/** Another higher order function that return a function */
	public static Function<String, String> strJoint(String first){
		return (String next) -> first + " " + next;
	}
}