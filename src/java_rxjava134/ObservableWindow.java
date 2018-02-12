package java_rxjava134;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Observable window
 *
 * @author ÌÆÁú
 *
 */
public class ObservableWindow {
	public static void main(String[] args) {
		// window
		testWindow();
	}

	/** test for window
	 *
	 * the Observable instance created by the window() operator emits Observable
	 * instances emitting the collected elements.
	 *
	 * This operator collects elements emitted within the timespan interval and
	 * skips all the elements emitted within the timeshift interval.
	 */
	private static void testWindow() {
		Observable<Integer> data = Observable
				.just(1, 2, 3)
				.window(100L, 10L, TimeUnit.MILLISECONDS)
				.flatMap(o -> o);
		Commons.subscribePrint(data, "Window");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}