package java_rxjava134;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import rx.Observable;

/**
 * OddFilter test
 *
 * @author ÌÆÁú
 *
 */
public class OddFilterTest {
	@Test
	public void testFiltersOddOfTheSequence() {
		Observable<String> tested = Observable
				.just("One", "Two", "Three")
				.compose(new OddFilter<String>());
		List<String> expected = Arrays.asList("One", "Three");
		List<String> actual = tested
				.toList()
				.toBlocking()
				.single();
		assertEquals(expected, actual);
	}
}