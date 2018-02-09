package java_rxjava134;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/**
 * Observable retry
 *
 * when 'retry' is invoked:
 * if Obserable encounter an Error
 * something will be done repeatly
 *
 * @author ÌÆÁú
 *
 */
public class ObservableRetry {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// retry
		Commons.subscribePrint(Observable.create(new ErrorEmitter()).retry(), "Retry");
		// retryWhen
		testRetryWhen();
	}

	/** test for retryWhen */
	private static void testRetryWhen() {
		@SuppressWarnings("deprecation")
		Observable<Integer> when = Observable.create(new ErrorEmitter())
		.retryWhen(attempts -> {
			return attempts.flatMap(error -> {
				if (error instanceof FException) {
					System.err.println("Delaying...");
					return Observable.timer(100L, TimeUnit.MICROSECONDS);
				}
				return Observable.error(error);
			});
		})
		.retry((attempts, error) -> {
			return (error instanceof SException) && attempts < 0;
		});
		Commons.subscribePrint(when, "retryWhen");
	}
}

/** Exception 1 */
class FException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FException() {
		super("FirstException!");
	}
}

/** Exception 2 */
class SException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SException() {
		super("Second Exception!");
	}
}

/** Error emitter */
class ErrorEmitter implements OnSubscribe<Integer> {
	private int throwAnErrorCounter = 3;

	@Override
	public void call(Subscriber<? super Integer> subscriber) {
		// if 'retry' is invoked this code will be executed {throwAnErrorCounter} times
		subscriber.onNext(-1);
		if (throwAnErrorCounter > 1) {
			throwAnErrorCounter--;
			subscriber.onError(new FException());
			return;
		}
		if (throwAnErrorCounter > 0) {
			throwAnErrorCounter--;
			subscriber.onError(new SException());
			return;
		}
		subscriber.onNext(1);
		subscriber.onCompleted();
	}
}