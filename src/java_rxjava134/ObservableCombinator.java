package java_rxjava134;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable combinator
 * 1. zip
 * 2. zipWith
 * 3. combineLatest
 * 4. merge
 * 5. mergeDelayError
 * 6. concat
 * 7. startWith
 *
 * @author ÌÆÁú
 *
 */
public class ObservableCombinator {
	public static void main(String[] args) {
		// zip
		testZip();
		// zip
		testZip2();
		// zipWith
		testZipWith();
		// combineLatest
		testCombineLatest();
		ObservableCombinator oc = new ObservableCombinator();
		// combineLatest
		oc.testCombineLatest2();
		// merge
		oc.testMerge();
		// mergeDelayError
		oc.testMergeDelayError();
		// concat
		oc.testConcat();
		// startWith
		oc.testStartWith();
	}

	/** test 'zip'
	 *
	 * The first item emitted by the Observable instance created by the zip() method
	 * is emitted by the time all of the sources have emitted at least one item.This
	 * means that even if one of the sources emits all of its items, the result will
	 * be emitted only when all of the other sources emit items.
	 */
	private static void testZip() {
		Observable<Integer> zip = Observable
				.zip(
						Observable.just(1, 3, 5),
						Observable.just(2, 4, 6, 8),
						(a, b) -> a + b
						);
		Commons.subscribePrint(zip, "CombineZip");
	}

	/** Another test for zip
	 *
	 * it has an Observable parameter that delivers
	 * a specified time detemining the speed of items emission
	 */
	private static void testZip2() {
		Observable<String> timedZip = Observable
				.zip(
						Observable.from(Arrays.asList("Z", "I", "P")),
						Observable.interval(100L, TimeUnit.MILLISECONDS),
						(value, i) -> value
						);
		Commons.subscribePrint(timedZip, "Timed zip");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for zipWith
	 *
	 * it's analogous to testZip2
	 */
	private static void testZipWith() {
		Observable<String> timedZip = Observable
				.from(Arrays.asList("Z", "I", "P"))
				.zipWith(
						Observable.interval(100L, TimeUnit.MILLISECONDS),
						(value, i) -> value
						);
		Commons.subscribePrint(timedZip, "Timed zipWith");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for 'combineLatest'
	 *
	 * The Observable instance it creates emits the first item as soon as
	 * there is at least one of each source,taking the last of each.
	 * After that, the Observable instance it creates emits an item whenever
	 * any of the source Observable instances emits an item. The number of
	 * items emitted by the combineLatest() operator depends entirely on the
	 * order of items emitted, since multiple items could be emitted from a
	 * single source before there is one of each source
	 */
	private static void testCombineLatest() {
		Observable<Integer> zip = Observable
				.combineLatest(
						Observable.just(1, 3, 5),
						Observable.just(2, 4, 6, 8, 11),
						(a, b) -> a + b
						);
		Commons.subscribePrint(zip, "CombineLatest");
	}

	/** some global arguments */
	private Observable<String> greetings = Observable
			.just("Hello", "Hi", "Good to see you")
			.zipWith(
					Observable.interval(300L, TimeUnit.MILLISECONDS),
					this::onlyFirstArg
					);
	private Observable<String> names = Observable
			.just("Meddle", "Dali", "Tanglong")
			.zipWith(
					Observable.interval(200L, TimeUnit.MILLISECONDS),
					this::onlyFirstArg
					);
	private Observable<String> punctuation = Observable
			.just(".", "?", "!")
			.zipWith(
					Observable.interval(50L, TimeUnit.MILLISECONDS),
					this::onlyFirstArg
					);
	private Observable<Object> errors = Observable
			.just(new Exception(), new InterruptedException())
			.zipWith(
					Observable.interval(500L, TimeUnit.MILLISECONDS),
					this::onlyFirstArg
					);

	/** Another test for 'combineLatest' */
	private void testCombineLatest2() {
		Observable<String> combined = Observable
				.combineLatest(
						greetings, names, punctuation,
						(greeting, name, puntuation)-> greeting + " " + name + puntuation
						);
		Commons.subscribePrint(combined, "CombineLatest Sentences");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for 'merge'
	 *
	 * interleaved results
	 */
	private void testMerge() {
		Observable<Object> combined = Observable
				.merge(greetings, names, punctuation, errors);
		Commons.subscribePrint(combined, "Merge Sentences");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for 'mergeDelayError'
	 *
	 * delays emitting errors until all the error-free
	 * source Observable instances are completed
	 */
	private void testMergeDelayError() {
		Observable<Object> combined = Observable
				.mergeDelayError(greetings, names, punctuation, errors);
		Commons.subscribePrint(combined, "MergeDelayError Sentences");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for concat
	 *
	 * The main difference between the merge() and concat() operators is
	 * that merge()subscribes to all source Observable instances at the
	 * same time,whereas concat()has exactly one subscription at any time.
	 */
	private void testConcat() {
		Observable<String> combined = Observable
				.concat(greetings, names, punctuation);
		Commons.subscribePrint(combined, "Concat Sentences");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void testStartWith() {
		Observable<String> combined = greetings
				.startWith(names)
				.startWith(punctuation);
		Commons.subscribePrint(combined, "StartWith Sentences");
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** only the first argument
	 *
	 * A custom function for 'combineLatest'
	 */
	@SuppressWarnings("hiding")
	public <T, R> T onlyFirstArg(T arg1, R arg2) {
		return arg1;
	}
}