package java_rxjava134;

import static java_rxjava134.Commons.cutOffLine;
import static java_rxjava134.Commons.debug;

import java.util.concurrent.CountDownLatch;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Combining Observables and schedulers(multi-threading)
 *
 * @author ÌÆÁú
 *
 */
public class ObservableCombineScheduler {
	public static void main(String[] args) {
		// subscribeOn
		testSubscribeOn();
		cutOffLine();
		//No subscribeOn
		testNoSubscribeOn();
		cutOffLine();
		// multiple subscribeOn
		testMultipleSubscribeOn();
		cutOffLine();
		// observeOn
		testObserveOn();
		cutOffLine();
		// test observeOn and subscribeOn
		testObserveOnSubscribeOn();
	}

	/** test for no 'subscribeOn' */
	private static void testNoSubscribeOn(){
		Observable<Integer> range = Observable
				.range(20, 4)
				.doOnEach(debug("Source"));
		range.subscribe();
		System.out.println("Hey!");
	}

	/** test for 'subscribeOn'
	 * @throws InterruptedException
	 */
	private static void testSubscribeOn(){
		CountDownLatch latch = new CountDownLatch(1);
		@SuppressWarnings("deprecation")
		Observable<Integer> range = Observable
		.range(20, 4)
		.doOnEach(debug("Source"))
		.subscribeOn(Schedulers.computation())
		.finallyDo(() -> latch.countDown());
		range.subscribe();
		System.out.println("Hey!");
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for multiple subscribeOn
	 *
	 * The call to it that is the closest to the beginning of the chain matters.
	 * Here we subscribe on the computation scheduler first, then on the IO scheduler,
	 * and then on the new thread scheduler, but our code will be executed on the
	 * computation scheduler because this is specified first in the chain.
	 */
	private static void testMultipleSubscribeOn(){
		CountDownLatch latch = new CountDownLatch(1);
		Observable<Integer> range = Observable
				.range(20, 3)
				.doOnEach(debug("Source"))
				.subscribeOn(Schedulers.computation()); // 1
		@SuppressWarnings("deprecation")
		Observable<Character> chars = range
		.map(n -> n + 48)
		.map(n -> Character.toChars(n))
		.subscribeOn(Schedulers.io()) // 2
		.map(c -> c[0])
		.subscribeOn(Schedulers.newThread()) // 3
		.doOnEach(debug("Chars"))
		.finallyDo(() -> latch.countDown());
		chars.subscribe();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for ObserveOn
	 *
	 * The observeOn() operator is similar to the subscribeOn() operator, but
	 * instead of executing the entire chain on the passed Scheduler instances
	 * it executes the part of the chain from its place within it, onwards.
	 *
	 * Here, we tell the Observable chain to execute on the main thread after
	 * subscribing until it reaches the observeOn() operator. At this point,
	 * it is moved on the computation scheduler.
	 */
	private static void testObserveOn(){
		CountDownLatch latch = new CountDownLatch(1);
		Observable<Integer> range = Observable
				.range(20, 3)
				.doOnEach(debug("Source"));
		@SuppressWarnings("deprecation")
		Observable<Character> chars = range
		// .observeOn(Schedulers.computation()) // scheduler startup position
		.map(n -> n + 48)
		.doOnEach(debug("+48 "))
		.map(n -> Character.toChars(n))
		.map(c -> c[0])
		// scheduler startup position, enter a new thread
		// If we move the observeOn() operator up the Observable chain,
		// a greater part of the logic will be executed using the computation scheduler.
		.observeOn(Schedulers.computation())
		.doOnEach(debug("Chars ", " "))
		.finallyDo(() -> latch.countDown());
		chars.subscribe();
		System.out.println("Hey!");
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for observeOn & subscribeOn */
	private static void testObserveOnSubscribeOn(){
		CountDownLatch latch = new CountDownLatch(1);
		Observable<Integer> range = Observable
				.range(20, 3)
				.subscribeOn(Schedulers.newThread()) // subscribeOn position
				.doOnEach(debug("Source"));
		@SuppressWarnings("deprecation")
		Observable<Character> chars = range
		.observeOn(Schedulers.io())          // observeOn position
		.map(n -> n + 48)
		.doOnEach(debug("+48 ", " "))
		.observeOn(Schedulers.computation()) // observeOn position
		.map(n -> Character.toChars(n))
		.map(c -> c[0])
		.doOnEach(debug("Chars ", " "))
		.finallyDo(() -> latch.countDown());
		chars.subscribe();
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}