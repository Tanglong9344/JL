package java_junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Assertions in JUnit
 *
 * @author Administrator
 *
 */
public class AssertionsTest {
	@Test
	public void test() {
		String obj1 = "junit";
		String obj2 = "junit";
		String obj3 = null;
		int var1 = 1;
		int var2 = 2;
		int[] a1 = { 1, 2, 3 };
		int[] a2 = { 1, 2, 3 };

		assertEquals(obj1, obj2);

		assertTrue(var1 != var2);

		assertFalse(var1 == var2);

		assertNotNull(obj1);

		assertNull(obj3);

		assertSame(obj1, obj2);

		assertNotSame(obj2, obj3);

		assertArrayEquals(a1, a2);
	}
}