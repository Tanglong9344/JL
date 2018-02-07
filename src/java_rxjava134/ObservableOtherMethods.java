package java_rxjava134;

import static java_rxjava134.CommonMethod.subscribePrint;

import java.util.Arrays;

import rx.Observable;
/**
 * Other methods
 *
 * @author ÌÆÁú
 *
 */
public class ObservableOtherMethods {
	public static void main(String[] args) {
		int DEFAULT_NUMBER = -1;
		Observable<Integer> numbers = Observable.just(13, 23, 8, 55, 23);
		// TakeLast series
		subscribePrint(numbers.last(), "Last"); // get the last item
		subscribePrint(numbers.first(), "First"); // get the first item
		subscribePrint(numbers.take(3), "Take 3"); // get the first three items
		subscribePrint(numbers.skipLast(3), "SkipLast 3"); //skip the last three items
		subscribePrint(numbers.takeLast(3), "TakeLast 3"); // get the last three items
		subscribePrint(numbers.takeLastBuffer(4), "TakeLastBuffer 3");
		subscribePrint(numbers.lastOrDefault(DEFAULT_NUMBER), "LastOrDefault"); // get the last item or the defaut one
		subscribePrint(Observable.empty().lastOrDefault(DEFAULT_NUMBER), "LastOrDefault");
		subscribePrint(numbers.elementAt(3), "ElementAt 3"); // get item at specified position
		subscribePrint(numbers.elementAtOrDefault(99, DEFAULT_NUMBER), "ElementAtOrDefault 3");
		subscribePrint(numbers.distinct(), "Distinct"); // get all items excluding repeated ones
		subscribePrint(numbers.distinctUntilChanged(), "DistinctUntilChanged"); // get all items excluding one that is same to it's predecessor

		// get items that meet the specified type
		// 'ofType' is shortcut of 'filter(v -> Class.isInstance(v)).'
		subscribePrint(
				Observable
				.from(Arrays.asList('c', 1, "RxJava" , 5, true, 8))
				.ofType(Integer.class), "OfType Integer");
	}
}