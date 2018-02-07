package java_rxjava134;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * @version RxJava-1.3.4
 *
 * Observable factory methods
 * 1. from
 * 2. just
 * 3. create
 *
 * @author ÌÆÁú
 *
 */
public class RxJavaObservableFactoryMethods {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		/** creating the Observable instances from collections or arrays using <method>from</method>*/
		// from a list
		List<String> list = Arrays.asList("red", "blue", "green");
		Observable<String> listObservable = Observable.from(list);
		listObservable.subscribe(System.out::println);
		// from a array
		Observable<Integer> arrayObservable = Observable.from(new Integer[] {3, 5, 8});
		arrayObservable.subscribe(System.out::println);

		/** creating the Observable instances from object using <method>just</method> */
		// The <method>just</method> method emits its parameter(s) as OnNext
		// notifications, and after that, it emits an OnCompleted notification
		// one letter:
		Observable.just('S').subscribe(System.out::println);
		// a sequence of letters:
		Observable
		.just('R', 'x', 'J', 'a', 'v', 'a')
		.subscribe(
				System.out::print,
				System.out::println,
				System.out::println
				);
		// get the length of a string
		Observable
		.just("Hello RxJava") // transform
		.map(s->("Length of '"+ s + "': " + s.length())) // process
		.subscribe(System.out::println); // action
		/** The Observable.create method */
		/** another method */
		CommonMethod.subscribePrint(
				Observable.interval(500L, TimeUnit.MILLISECONDS),
				"Interval Observable"
				);
		CommonMethod.subscribePrint(
				Observable.timer(0L, 1L, TimeUnit.SECONDS),
				"Timed Interval Observable"
				);
		CommonMethod.subscribePrint(
				Observable.timer(1L, TimeUnit.SECONDS),
				"Timer Observable"
				);
		CommonMethod.subscribePrint(
				Observable.error(new Exception("Test Error!")),
				"Error Observable"
				);
		CommonMethod.subscribePrint(Observable.empty(), "Empty Observable");
		CommonMethod.subscribePrint(Observable.never(), "Never Observable");
		CommonMethod.subscribePrint(Observable.range(1, 3), "Range Observable");

		// sleep 2s
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}