package java_rxjava134;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Reactive functions test
 *
 * @author ÌÆÁú
 *
 */
public class ReactiveFunction {
	public static void main(String[] args) throws Exception {
		// random number
		int value = (int)(Math.random()*10);
		// predicate
		Predicate<Integer> odd = (val) -> val % 2 != 0;
		System.out.printf("%d ÊÇÆæÊý: %s%n", value, odd.test(value));
		// consumer
		Consumer<String> print = System.out::println;
		print.accept("Hello Consumer<T>");
		// function
		Function<Integer, String> toStr = (val)->(val + "--to--String");
		print.accept(toStr.apply(value));
	}
}