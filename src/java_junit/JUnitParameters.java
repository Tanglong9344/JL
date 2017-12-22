package java_junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * JUnit Paramters
 *
 * @author ÌÆÁú
 *
 */
@RunWith(Parameterized.class)
public class JUnitParameters {
	private int expected;
	private int first;
	private int second;

	/**Constructor*/
	public JUnitParameters(int expected, int first, int second) {
		this.expected = expected;
		this.first = first;
		this.second = second;
	}

	@Parameters
	public static Collection<Integer[]> addedNumbers() {
		return Arrays.asList(new Integer[][] {{3, 1, 2}, {5, 2, 3}, {7, 3, 4}});
	}

	@Test
	public void sum() {
		System.out.printf("Addition with parameters: %d and %d%n", first, second);
		assertEquals(expected, Calculate.add(first, second));
	}
}

/**Calculate*/
class Calculate{
	public static int add(int a, int b) {
		return a + b;
	}
}