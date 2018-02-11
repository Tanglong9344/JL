package java_rxjava134;

import java.util.concurrent.atomic.AtomicReference;

import rx.Notification;
import rx.Observable;
import rx.functions.Action1;

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
	@SuppressWarnings("hiding")
	public static <T> void subscribePrint(Observable<T> observable, String name) {
		observable.subscribe(
				(v) -> System.out.println("'" + name + "' : " + v), // OnNext
				(e) -> System.err.println("Error from '" + name + "':" + e.getMessage()), // OnError
				()  -> System.out.println("'" + name + "' Ended!") // OnCompleted
				);
	}

	/** debug method that return an action */
	public static <T> Action1<Notification<? super T>> debug(String description, String offset ) {
		AtomicReference<String> nextOffset = new AtomicReference<String>(">");
		return (Notification<? super T> notification) -> {
			switch (notification.getKind()) {
			case OnNext:
				System.out.println(Thread.currentThread().getName() + "|" + description
						+ ": " + offset + nextOffset.get() + notification.getValue());
				break;
			case OnError:
				System.err.println(Thread.currentThread().getName() + "|" + description + ": "
						+ offset + nextOffset.get() + " X " + notification.getThrowable());
				break;
			case OnCompleted:
				System.out.println(Thread.currentThread().getName()
						+ "|" + description + ": " + offset + nextOffset.get() + "|");
			default:
				break;
			}
			nextOffset.getAndUpdate(p -> "-" + p);
		};
	}

	/** an overload of 'debug' method */
	public static <T> Action1<Notification<? super T>> debug(String description){
		return debug(description, "");
	}

	/** cut-off line */
	public static void cutOffLine() {
		System.out.println("----------CUT-OFF LINE--------------");
	}
}