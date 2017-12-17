package java_lamda_expression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Java Functional Programming
 *
 * @author 唐龙
 */
public class FunctionalProgramming {
	public static void main(String[] args) {
		// 无参构造器
		Runnable r = () -> System.out.println("No arguments,Hello World");
		r.run();

		// 一个参数
		Function<String,Integer> parseInt = (String s)->Integer.parseInt(s);
		System.out.println("Parse String to int: " + parseInt.apply("12"));

		// 两个参数
		BinaryOperator<Long> add = (x, y) -> x + y;
		System.out.println("1+1=" + add.apply(1L, 1L));

		// 明确参数类型
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
		System.out.println("1+2=" + addExplicit.apply(1L, 2L));

		// 多语句
		Runnable multiStatement = () -> {
			System.out.print("Hello");
			System.out.println(" World");
		};
		multiStatement.run();

		// 事件监听
		ActionListener listener = event -> System.out.println("Event Listener,button clicked");
		ActionEvent e = null;
		listener.actionPerformed(e);
	}
}