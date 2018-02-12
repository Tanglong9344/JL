package java_rxjava134;

import static java_rxjava134.Commons.cutOffLine;

import java.util.Iterator;
import java.util.List;

import rx.Observable;

/**
 * Observable aggregate operators
 *
 * @author ÌÆÁú
 *
 */
public class ObservableAggregateOperators {
	public static void main(String[] args) {
		// count
		testCount();
		cutOffLine();
		// toList
		testToList();
		cutOffLine();
		// toSortedList
		testToSortedList();
		cutOffLine();
		// blocking single
		testToListBlocking();
	}

	/** test for 'count' */
	private static void testCount() {
		Observable
		.just(63, 5, 17, 9, 212, 34)
		.count() // emits the number of the items emitted by the source Observable instance
		.subscribe(System.out::println);
	}

	/** test for 'toList' */
	private static void testToList() {
		Observable
		.just(63, 5, 17, 9, 212, 34)
		.toList()
		.subscribe(System.out::println);
	}

	/** test for 'tooSortedList' */
	private static void testToSortedList() {
		Observable
		.just(63, 5, 17, 9, 212, 34)
		.toSortedList()
		.subscribe(System.out::println);
	}

	/** test for 'toList' and 'toBlocking' */
	private static void testToListBlocking() {
		List<Integer> o = Observable
				.just(63, 5, 17, 9, 212, 34)
				.toList()
				.toBlocking()
				.single();

		for(Iterator<Integer> i = o.iterator();i.hasNext();) {
			System.out.println("Blocking Single: " + i.next());
		}
	}
}