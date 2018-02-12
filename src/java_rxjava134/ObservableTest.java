package java_rxjava134;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Observable test
 *
 * @author ÌÆÁú
 *
 */
@SuppressWarnings("deprecation")
public class ObservableTest {
	/** list test */
	@Test
	public void testUsingBlockingObservable() {
		List<Integer> expected = Arrays.asList(7, 8, 44, 5);
		List<Integer> result = Observable
				.just(7, 8, 44, 5)
				.toList()
				.toBlocking()
				.single();
		Assert.assertEquals(expected, result);
	}

	/** test for 'TestSubscribe' */
	@Test
	public void testUsingTestSubscriber() {
		TestSubscriber<Integer> subscriber = new TestSubscriber<Integer>();
		List<Integer> expected = Arrays.asList(7, 8, 5);
		Observable<Integer> tested = Observable.just(7, 8, 5);
		tested.subscribe(subscriber);
		// With the getOnNextEvents() method, we are able to retrieve
		// all the items emitted by the Observable instance and compare
		// them to the expected List variable.
		Assert.assertEquals(expected, subscriber.getOnNextEvents());
		// With the getOnCompletedEvents() method, we are able to inspect
		// the OnCompleted notification and to check if it was sent at all.
		Assert.assertSame(1, subscriber.getOnCompletedEvents().size());
		// With the getOnErrorEvents() method, we are able to
		// inspect OnError notifications if there were any.
		Assert.assertTrue(subscriber.getOnErrorEvents().isEmpty());
		// Using the isUnsubscribed() method, we can assert that, after
		// everything completed, our Subscriber instances were unsubscribed.
		Assert.assertTrue(subscriber.isUnsubscribed());
	}

	/** test for TestSubscribe Assertions */
	@Test
	public void testUsingTestSubscriberAssertions() {
		TestSubscriber<Integer> subscriber = new TestSubscriber<Integer>();
		List<Integer> expected = Arrays.asList(7, 8, 5);
		Observable<Integer> tested = Observable.just(7, 8, 5);
		tested.subscribe(subscriber);
		subscriber.assertReceivedOnNext(expected);
		subscriber.assertTerminalEvent();
		subscriber.assertNoErrors();
		subscriber.assertUnsubscribed();
	}
}