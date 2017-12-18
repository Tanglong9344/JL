package java_junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A simple JUnit4 demo°£
 *
 * @author Tanglong
 *
 */
public class SumJUnit {
	int sum ;
	@Before
	public void setSum() {
		sum = Sum.add(2, 5);
	}

	@Test
	public void testSum() {
		assertEquals("", 7, sum);
		assertEquals("", 7, sum + 1);
	}
}

/**JUnit¥˝≤‚ ‘¿‡*/
class Sum{
	public static int add(int vala, int valb) {
		return vala + valb;
	}
}