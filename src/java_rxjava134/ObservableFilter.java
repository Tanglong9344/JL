package java_rxjava134;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

/**
 * Obserable filter
 *
 * @author ÌÆÁú
 *
 */
public class ObservableFilter {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 4, 7, 8, 4, 67, 86);
		// filter
		filterEven(numbers);
	}

	/** filter even number */
	private static void filterEven(List<Integer> list) {
		Observable<Integer> filter = Observable
				.from(list)
				.filter(n -> n % 2 == 0);
		CommonMethod.subscribePrint(filter, "FilterEven");
	}
}