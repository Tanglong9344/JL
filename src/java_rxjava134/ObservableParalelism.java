package java_rxjava134;

import static java_rxjava134.Commons.debug;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Observable parallelism
 * @author ÌÆÁú
 *
 */
public class ObservableParalelism {
	public static void main(String[] args) {
		// parallelism
		testParallelism();
	}

	/** test for parallelism */
	private static void testParallelism() {
		Observable<Integer> range = Observable
				.range(20, 3)
				.flatMap(n -> Observable
						.range(n, 3)
						.subscribeOn(Schedulers.computation())
						.doOnEach(debug("Source")));
		range.subscribe();
		// sleep 1s
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("parallelism...");
	}
}