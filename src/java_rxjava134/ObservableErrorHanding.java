package java_rxjava134;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Obserable errors handing
 * 1. onErrorReturn
 * 2. onExceptionResumeNext
 * 3. onErrorResumeNext();
 *
 * @author ÌÆÁú
 *
 */
public class ObservableErrorHanding {
	public static void main(String[] args) {
		// onErrorReturn
		testOnErrorReturn();
		// onExceptionResumeNext
		testOnExceptionResumeNext();
		// onErrorResumeNext
		testOnErrorResumeNext();
		// doOnNext, doOnError, doOnCompleted and finallyDo
		testDoOns();
	}

	/** test onErrorReturn */
	private static void testOnErrorReturn() {
		Observable<Integer> numbers = Observable
				.just("1", "three", "5")
				.map(Integer::parseInt)
				.onErrorReturn(e -> -1); // it will return '-1' and completed when encounter item 'three'
		Commons.subscribePrint(numbers, "OnErrorReturn");
	}

	/** test onExceptionResumeNext */
	private static void testOnExceptionResumeNext() {
		Observable<Integer> defaultNumbers = Observable.just(6, 66, 666);
		Observable<Integer> numbers = Observable
				.just("1", "three", "5")
				.map(Integer::parseInt)
				.onExceptionResumeNext(defaultNumbers); // it will turn to 'defaultNumbers' when encounter item 'three'
		Commons.subscribePrint(numbers, "OnExceptionResumeNext");
	}

	/** test onErrorResumeNext
	 *
	 * 1. the onErrorResumeNext() operator has an additional overload
	 * that takes a lambda expression, returning the Observable instance
	 * (similar to the onErrorReturn() method)
	 * 2. it will react to every kind of error. The onExceptionResumeNext()
	 * method reacts only to instances of the Exception class and its subclasses
	 */
	private static void testOnErrorResumeNext() {
		Observable<Integer> defaultNumbers = Observable.just(6, 66, 666);
		Observable<Integer> numbers = Observable
				.just("1", "three", "5")
				.map(Integer::parseInt)
				.onErrorResumeNext(defaultNumbers); // it will turn to 'defaultNumbers' when encounter item 'three'
		Commons.subscribePrint(numbers, "OnErrorResumeNext");
	}

	/** test for doOnNext, doOnError, doOnCompleted and finallyDo */
	static int cnt = 1;
	private static void testDoOns() {
		@SuppressWarnings("deprecation")
		Observable<Integer> numbers = Observable
		.just("1", "three", "5")
		.map(Integer::parseInt)
		.doOnNext(new Action1<Object>() {
			@Override
			public void call(Object arg0) {
				System.out.println("Do something onNext-" + (cnt++)); // 1
			}
		})
		.doOnError(new Action1<Object>() {
			@Override
			public void call(Object arg0) {
				System.out.println("Do something onError-" + (cnt++)); // 2
			}
		})
		.doOnCompleted(new Action0() {
			@Override
			public void call() {
				System.out.println("Do something onCompleted-" + (cnt++)); // 3
			}
		})
		.finallyDo(new Action0() {
			@Override
			public void call() {
				System.out.println("Finally do something-" + (cnt++));
			}
		});
		Commons.subscribePrint(numbers, "DoOn*");
	}
}