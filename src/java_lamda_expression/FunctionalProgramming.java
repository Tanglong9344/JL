package java_lamda_expression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Java Functional Programming
 *
 * @author ����
 */
public class FunctionalProgramming {
	public static void main(String[] args) {
		// �޲ι�����
		Runnable r = () -> System.out.println("No arguments,Hello World");
		r.run();

		// һ������
		Function<String,Integer> parseInt = (String s)->Integer.parseInt(s);
		System.out.println("Parse String to int: " + parseInt.apply("12"));

		// ��������
		BinaryOperator<Long> add = (x, y) -> x + y;
		System.out.println("1+1=" + add.apply(1L, 1L));

		// ��ȷ��������
		BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
		System.out.println("1+2=" + addExplicit.apply(1L, 2L));

		// �����
		Runnable multiStatement = () -> {
			System.out.print("Hello");
			System.out.println(" World");
		};
		multiStatement.run();

		// �¼�����
		ActionListener listener = event -> System.out.println("Event Listener,button clicked");
		ActionEvent e = null;
		listener.actionPerformed(e);
	}
}