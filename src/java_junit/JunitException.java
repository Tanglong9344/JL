package java_junit;

import org.junit.Test;

/**
 * Exception in JUnit
 *
 * @author ÌÆÁú
 *
 */
public class JunitException{
	//@Ignore
	@Test(expected = ArithmeticException.class)
	public void divisionWithException() {
		@SuppressWarnings("unused")
		int i = 1/0;
	}
}
