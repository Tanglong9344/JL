package java_rxjava134;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.TimeInterval;
import rx.schedulers.Timestamped;

/**
 * Obserable transform
 * 1. map
 * 2. flatMap
 * 3. concatMap
 * 4. switchMap
 * 5. cast
 * 6. timestamp
 *
 * @author ÌÆÁú
 *
 */
public class ObservableTransfrom {
	public static void main(String[] args) {
		// transformation
		classifyNumber();
		System.out.println();
		// flatMap
		testFlatMap();
		// flatMap
		testFlatMap2();
		// merge two lists
		mergeList();
		// switchMap
		testSwitchMap();
		// cast
		testCast();
		// timestamp
		testTimeStamp();
		// timeInterval
		testTimeInterval();
	}

	/** map, classify odd & even */
	private static void classifyNumber() {
		Observable
		.just(2, 3, 5, 8, 11)
		.map(v -> v + 1)
		.map(v -> ((v % 2 == 0) ? "even" : "odd"))
		.subscribe(System.out::println);
	}

	/** a test for flatMap */
	private static void testFlatMap() {
		Observable
		.just(-1, 2, 0, 1)
		.map(v -> 2 / v)
		.flatMap(
				v -> Observable.just(v), // OnNext
				e -> Observable.just(0), // OnError
				() -> Observable.just(Integer.MAX_VALUE) // OnCompleted
				)
		.subscribe(System.out::println);
	}

	/** another test for flatMap */
	private static void testFlatMap2() {
		Observable<Integer> flatMapped = Observable
				.just(3)
				.flatMap(
						v -> Observable.range(v + 1, 3),
						(x, y) -> x + y);
		CommonMethod.subscribePrint(flatMapped, "flatMap");
	}

	/** merge two list using list and traverse them with flatMapIterable */
	private static void mergeList() {
		Observable<?> fmi = Observable
				.just(
						Arrays.asList(2, 4),
						Arrays.asList("Two", "Four")
						).
				flatMapIterable(list -> list);
		CommonMethod.subscribePrint(fmi, "FlatMapIterable");
	}

	/** test for switchMap */
	@SuppressWarnings("deprecation")
	private static void testSwitchMap() {
		Observable<Object> obs = Observable
				.interval(300L, TimeUnit.MILLISECONDS)
				.switchMap(v -> Observable
						.timer(0L, 50L, TimeUnit.MILLISECONDS)
						.map(u -> "Observable <" + (v + 1) + "> : " + (v + u))
						);
		CommonMethod.subscribePrint(obs, "switchMap");
		try {
			Thread.sleep(1000L); // sleep 1s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test from 'cast' which is shortcut of 'map(v -> someClass.cast(v))' */
	private static void testCast() {
		List<Number> list = Arrays.asList(1, 2, 3);
		Observable<Integer> Iobs = Observable
				.from(list)
				.cast(Integer.class); //.map(e->Integer.class.cast(e));
		CommonMethod.subscribePrint(Iobs, "ObservableCast");
	}

	/** test for 'timestamp' */
	private static void testTimeStamp() {
		List<Number> list = Arrays.asList(1, 3, 2);
		Observable<Timestamped<Number>> timestamp = Observable
				.from(list)
				.timestamp(); // add timestamp to every element
		CommonMethod.subscribePrint(timestamp, "Timestamps");
	}

	/** test for 'timeInterval'
	 *
	 * show the time that elapsed either since the emission of the
	 * previous item, or (if there was no previous item) since the subscription
	 * */
	private static void testTimeInterval() {
		List<Number> list = Arrays.asList(1, 3, 2);
		Observable<TimeInterval<Number>> timesInterval = Observable
				.from(list)
				.timeInterval(); // add time interval to every element
		CommonMethod.subscribePrint(timesInterval, "TimeInterval");
	}
}