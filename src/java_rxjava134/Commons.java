package java_rxjava134;

import rx.Observable;

/**
 * Common methods or Constant
 *
 * @author ÌÆÁú
 *
 */
public class Commons {
	// common constant
	public static int DEFAULT_VALUE = -1;

	// common methods
	/** subscribe an Observable object with a label 'name' */
	public static <T> void subscribePrint(Observable<T> observable, String name) {
		observable.subscribe(
				(v) -> System.out.println("'" + name + "' : " + v), // OnNext
				(e) -> System.err.println("Error from '" + name + "':" + e.getMessage()), // OnError
				()  -> System.out.println("'" + name + "' Ended!") // OnCompleted
				);
	}
}