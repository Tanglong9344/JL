package java_rxjava134;

import static java_rxjava134.Commons.cutOffLine;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * backpressure
 * 1. throttling
 * 2. buffering
 * 3. debouncing
 *
 * @author ÌÆÁú
 *
 */
public class BackPressure {
	public static void main(String[] args) {
		// throttling
		// sample
		testThrottling();
		cutOffLine();
		// throttlingFirst
		testThrottlingFirst();
		cutOffLine();
		// debouncing
		testDebouncing();
	}

	/** test for throttling
	 *
	 * Using this mechanism(throttling), we can regulate the emission rate of an
	 * Observable instance.We can specify time intervals or another flow-controlling
	 * Observable instance to achieve this.
	 *
	 * Using the sample() operator, we can control the emissions of an Observable
	 * instance using another one, or a time interval.
	 *
	 * we can only get the last items emitted by the Observable, So we have great data loss.
	 */
	private static void testThrottling() {
		Observable<Integer> data = Observable.just(1, 2, 66); // In the case, we get '66'
		data = data
				.sample(Observable
						.interval(100L, TimeUnit.MILLISECONDS)
						.take(10)
						.concatWith(Observable.interval(200L, TimeUnit.MILLISECONDS)));
		Commons.subscribePrint(data, "sample");
	}

	/** test for 'throttlingFirst'
	 *
	 * we get the first items emitted by the Observable
	 *
	 * it's similar to '.sample(Long , TimeUnit)' and '.throttleLast(Long , TimeUnit)'
	 */
	private static void testThrottlingFirst() {
		Observable<Integer> data = Observable.just(1, 2, 66); // In the case, we get '66'
		data = data.throttleFirst(100L, TimeUnit.MILLISECONDS);
		Commons.subscribePrint(data, "throttlingFirst");
	}

	/** test for debouncing
	 *
	 * Here we are using the sample() operator with a special sampling Observable
	 * instance in order to reduce the emissions to occur on 100, 200,and 150
	 * milliseconds. By using the repeat() operator, we create an infinite Observable
	 * instance, repeating the source, and set it to execute on thecomputation scheduler
	 * Now we can use the debounce() operator to emit only this set of items with time gaps
	 * between their emissions of 150 or moremilliseconds.
	 *
	 * Debouncing, like throttling, can be used to filter similar events from an
	 * overproducing source. A good example of this is an auto-complete search.
	 */
	@SuppressWarnings("deprecation")
	private static void testDebouncing() {
		Observable<Object> sampler = Observable.create(subscriber -> {
			try {
				subscriber.onNext(0);
				Thread.sleep(100L);
				subscriber.onNext(10);
				Thread.sleep(200L);
				subscriber.onNext(20);
				Thread.sleep(150L);
				subscriber.onCompleted();
			} catch (Exception e) {
				subscriber.onError(e);
			}
		}).repeat().subscribeOn(Schedulers.computation());
		Observable<Integer> data = Observable.just(1, 2, 66);
		data
		.sample(sampler)
		.debounce(500L, TimeUnit.MILLISECONDS);
		Commons.subscribePrint(data, "debouncing");
	}
}