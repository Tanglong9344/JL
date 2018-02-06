package java_lamda_expression;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Lambda expression in java8
 *
 * @author ÌÆÁú
 *
 */
public class LambdaExpression {
	public static void main(String[] args) {
		List<String> list = java_common.CommonUtils.getList(3);

		// forEach()
		// commonly used way
		list.forEach(s->System.out.print(s + ", "));
		System.out.println();
		// specify the type
		list.forEach((String s)->System.out.print(s + ", "));
		System.out.println();
		// multiply statements
		list.forEach(s->{
			System.out.print("E: ");
			System.out.println(s);
		});
		// sort()
		// reversed order
		list.sort((e1, e2)->e2.compareTo(e1));
		System.out.println(list);

		// String concatenate
		BinaryOperator<String> add = (x, y) -> x + y;
		System.out.println(add.apply("Hello ", "World!"));
	}
}