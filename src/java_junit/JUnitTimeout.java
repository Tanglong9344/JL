package java_junit;

import org.junit.Test;

/**
 * Timeout in JUnit
 *
 * @author ÌÆÁú
 *
 */
public class JUnitTimeout {
	final int TIME = 1000;

	@Test(timeout = TIME)//waiting for 1000s
	public void lessSecond() throws InterruptedException {
		Thread.sleep(TIME - 10);//delay 999ms
	}

	@Test(timeout = TIME)//waiting for 1000ms
	public void moreSecond() throws InterruptedException {
		Thread.sleep(TIME + 10);//delay 1001ms
	}
}