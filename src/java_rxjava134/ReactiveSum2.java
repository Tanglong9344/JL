package java_rxjava134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.observables.ConnectableObservable;

/**
 * Reactive sum
 *
 * @author ÌÆÁú
 *
 */
public class ReactiveSum2 {
	public static void main(String[] args) {
		ConnectableObservable<String> input = from(System.in);
		Observable<Double> a = varStream("a", input);
		Observable<Double> b = varStream("b", input);
		ReactiveDoSum(a, b);
		input.connect();
	}

	/**
	 * from1
	 * @param stream
	 * @return
	 */
	static ConnectableObservable<String> from(final InputStream stream) {
		return from(new BufferedReader(new InputStreamReader(stream)));
	}

	/**
	 * from2
	 * @param reader
	 * @return
	 */
	@SuppressWarnings("deprecation")
	static ConnectableObservable<String> from(final BufferedReader reader) {
		return Observable.create(new OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				if (subscriber.isUnsubscribed()) {
					return;
				}
				try {
					String line;
					while(!subscriber.isUnsubscribed() && (line = reader.readLine()) != null) {
						if (line == null || line.equals("exit")) {
							break;
						}
						subscriber.onNext(line);
					}
				} catch (IOException e) {
					subscriber.onError(e);
				}
				if (!subscriber.isUnsubscribed()) {
					subscriber.onCompleted();
				}
			}
		}).publish();
	}

	/**
	 * varStream
	 * @param varName
	 * @param input
	 * @return
	 */
	public static Observable<Double> varStream(final String varName, Observable<String> input) {
		final Pattern pattern = Pattern.compile("\\^s*" + varName + "\\s*[:|=]\\s*(-?\\d+\\.?\\d*)$");
		return input
				.map(pattern::matcher) // ×ª»»
				.filter(m -> m.matches() && m.group(1) != null) // ¹ýÂË
				.map(matcher -> matcher.group(1))
				.map(Double::parseDouble);
	}

	/**
	 * ReactiveDoSum
	 * @param a
	 * @param b
	 */
	public static void ReactiveDoSum (Observable<Double> a, Observable<Double> b) {
		Observable
		.combineLatest(a, b, (x, y) -> x + y)
		.subscribe(
				sum -> System.out.println("update : a + b = " + sum),
				error -> {
					System.out.println("Something wrong!");
					error.printStackTrace();
				},
				() -> System.out.println("Exiting...")
				);
	}
}