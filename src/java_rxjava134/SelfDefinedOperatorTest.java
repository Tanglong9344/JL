package java_rxjava134;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Test for SelfDefinedOperator
 *
 * @author ÌÆÁú
 *
 */
public class SelfDefinedOperatorTest {
	@Test
	public void testGeneratesSequentialIndexes() {
		// The test emits the letters from 'a' to 'e' and uses the lift() operator to
		// insert our 'SelfDefinedOperator' operator implementation into the observable chain.
		Observable<Pair<Long, String>> observable = Observable
				.just("a", "b", "c")
				.lift(new SelfDefinedOperator<String>());
		List<Pair<Long, String>> expected = Arrays.asList(
				new Pair<Long, String>(0L, "a"),
				new Pair<Long, String>(1L, "b"),
				new Pair<Long, String>(2L, "c"));
		List<Pair<Long, String>> actual = observable
				.toList()
				.toBlocking().
				single();
		System.out.println("Actual  : " + actual + "\n\nExpected: " + expected);
		assertEquals(expected, actual);
		// Assert that it is the same result for a second
		TestSubscriber<Pair<Long, String>> testSubscriber = new TestSubscriber<Pair<Long, String>>();
		observable.subscribe(testSubscriber);
		testSubscriber.assertReceivedOnNext(expected);
	}
}