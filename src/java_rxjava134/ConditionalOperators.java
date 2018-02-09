package java_rxjava134;

import static java_rxjava134.Commons.DEFAULT_VALUE;
import static java_rxjava134.Commons.subscribePrint;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Conditional operators
 * 1. amb
 * 2. ambWith
 * 3. takeUntil
 * 4. takeWhile
 * 5. skipUntil
 * 6. defaultIfEmpoty
 *
 * @author ÌÆÁú
 *
 */
public class ConditionalOperators {
	public static void main(String[] args) {
		// amb
		testAmb();
		// ambWith
		testAmbWith();
		// takeUntil
		testTakeUntil();
		// takeWhile
		testTakeWhile();
		// skipUntil
		testSkipUntil();
		// defaultIfEmpoty
		testDefaultIfEmpoty();
	}

	/** test for 'amb'
	 *
	 * It emits the items of the source Observable instance
	 * that starts emitting first. It doesn't matter what this
	 * is, whether OnError, OnCompleted notification, or data
	 */
	private static void testAmb() {
		Observable<String> s1 = Observable.just("S11", "S12");
		Observable<String> s2 = Observable.just("S21", "S22");
		// 'words' will emite
		subscribePrint(Observable.amb(s1, s2), "Amb 1");

		Random r = new Random();
		Observable<String> source1 = Observable
				.just("data from source 1")
				.delay(r.nextInt(1000), TimeUnit.MILLISECONDS);
		Observable<String> source2 = Observable
				.just("data from source 2")
				.delay(r.nextInt(1000), TimeUnit.MILLISECONDS);
		// 'source2' or 'source1' will emite according to their emiting time
		subscribePrint(Observable.amb(source2, source1), "Amb 2");

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for embWith */
	private static void testAmbWith() {
		Observable<String> s1 = Observable.just("S11", "S12");
		Observable<String> s2 = Observable.just("S21", "S22");
		// 'words' will emite
		subscribePrint(s2.ambWith(s1), "Amb 1");
	}

	/** test takeUntil
	 *
	 * The first Observable will emits until the second start to emit
	 */
	private static void testTakeUntil() {
		Observable<String> words = Observable
				.just("I'm", "Tanglong", "I", "am", "learning", "RxJava")
				.zipWith(
						Observable.interval(100L, TimeUnit.MILLISECONDS),
						(x, y) -> x
						);
		Observable<Long> interval = Observable.interval(800L, TimeUnit.MILLISECONDS);
		subscribePrint(words.takeUntil(interval), "takeUntil");

		try {
			Thread.sleep(1500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test takeWhile
	 *
	 * 1. The first Observable will emits while meet the second's conditions
	 * 2. It will keep emiting until encounter the first one that doesn't meet the conditions
	 */
	private static void testTakeWhile() {
		Observable<String> words = Observable
				.just("I'm", "Tanglong", "I", "am", "learning", "RxJava")
				.zipWith(
						Observable.interval(100L, TimeUnit.MILLISECONDS),
						(x, y) -> x
						);
		subscribePrint(words.takeWhile(word -> word.length() > 2), "takeWhile");

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test skipUntil
	 *
	 * skip the items that meet the second's conditions
	 */
	private static void testSkipUntil() {
		Observable<String> words = Observable
				.just("I'm", "Tanglong", "I", "am", "learning", "RxJava")
				.zipWith(
						Observable.interval(100L, TimeUnit.MILLISECONDS),
						(x, y) -> x
						);
		Observable<Long> interval = Observable.interval(200L, TimeUnit.MILLISECONDS);
		subscribePrint(words.skipUntil(interval), "skipUntil");

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for defaultIfEmpoty */
	private static void testDefaultIfEmpoty() {
		Observable<Object> test = Observable
				.empty()
				.defaultIfEmpty(DEFAULT_VALUE);
		subscribePrint(test, "defaultIfEmpty");
	}
}