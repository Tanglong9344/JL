package java_lamda_expression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class FunctionalProgrammingTest {
	public static void main(String[] args) {
		Runnable noArguments = () -> System.out.println("Hello World");
		System.err.println("test1:"+noArguments);
		noArguments.run();

		ActionListener oneArgument = event -> System.out.println("button clicked");
		System.err.println("test2:"+oneArgument);
		ActionEvent e = null;
		oneArgument.actionPerformed(e);

		BinaryOperator<Long> add = (x, y) -> x + y;
		System.err.println("test3:"+add);
		System.out.println(add.apply(1L, 1L));

		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
		System.err.println("test4:"+addExplicit);
		System.out.println(addExplicit.apply(1L, 2L));

		Runnable multiStatement = () -> {
			System.out.print("Hello");
			System.out.println(" World");
		};
		System.err.println("test5:"+multiStatement);
		multiStatement.run();
	}
}