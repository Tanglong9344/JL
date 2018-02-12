package java_rxjava134;

import static java_rxjava134.Commons.cutOffLine;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observables.BlockingObservable;

/**
 * Observable blocking
 *
 * @author ÌÆÁú
 *
 */
public class ObservableBlocking {
	public static void main(String[] args) {
		// Blocking Observable
		testBlockingObservable();
		cutOffLine();
		// toBlocking
		testBlocking();
		cutOffLine();
		// next
		testNext();
		cutOffLine();
		// latest
		testLatest();
	}

	/** test for Blocking Observable */
	private static void testBlockingObservable() {
		BlockingObservable<Integer> o = Observable.range(3, 13).toBlocking();
		Integer first = o.first();
		System.out.println("First: " + first);
		Integer last = o.last();
		System.out.println("Last: " + last);
	}

	/** test for 'toBlocking' */
	private static void testBlocking() {
		Observable
		.interval(100L, TimeUnit.MILLISECONDS)
		.take(5)
		.toBlocking()
		.forEach(System.out::println);
		System.out.println("END");

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** test for 'next' */
	private static void testNext() {
		Iterable<Long> next = Observable
				.interval(100L, TimeUnit.MILLISECONDS)
				.toBlocking()
				.next();
		int cnt = 1;
		// generate iterator
		for(Iterator<Long> i = next.iterator();i.hasNext();) {
			System.out.println("Next: " + i.next());
			// wait for 200ms
			try {
				Thread.sleep(200L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(cnt++ > 5) { break;}
		}
	}

	/** test for 'latest'
	 *
	 * latest() is similar to next() which returns an Iterable instance.
	 * The behavior is different because the Iterable instance produced
	 * by the latest() method returns the very last items emitted by the
	 * source or waits for the next ones, if there aren't any.
	 */
	private static void testLatest() {
		Iterable<Long> next = Observable
				.interval(100L, TimeUnit.MILLISECONDS)
				.toBlocking()
				.latest();
		int cnt = 1;
		// generate iterator
		for(Iterator<Long> i = next.iterator();i.hasNext();) {
			System.out.println("Latest: " + i.next());
			// wait for 200ms
			try {
				Thread.sleep(200L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(cnt++ > 5) { break;}
		}
	}
}