package java_rxjava134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;
import rx.subjects.BehaviorSubject;

/**
 * Reactive sum
 *
 * @author ÌÆÁú
 *
 */
public class ReactiveSum3 {
	public static void main(String[] args) {
		ConnectableObservable<String> input = from(System.in);
		Observable<Double> a = varStream("a", input);
		Observable<Double> b = varStream("b", input);
		ReactiveDoSum3 sum = new ReactiveDoSum3(a, b);
		System.out.println(sum.getC());
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
				.map(new Func1<String, Matcher>() {
					@Override
					public Matcher call(String str) {
						return pattern.matcher(str);
					}
				})
				.filter(new Func1<Matcher, Boolean>() {
					@Override
					public Boolean call(Matcher matcher) {
						return matcher.matches() && matcher.group(1) != null;
					}
				})
				.map(new Func1<Matcher, Double>() {
					@Override
					public Double call(Matcher matcher) {
						return Double.parseDouble(matcher.group(1));
					}
				});
	}
}

/** ReactiveDoSum class */
final class ReactiveDoSum3 implements Observer<Double> {
	private BehaviorSubject<Double> c = BehaviorSubject.create(0.0);

	public ReactiveDoSum3(Observable<Double> a, Observable<Double> b) {
		Observable.combineLatest(a, b, (x, y) -> x + y).subscribe(c);
	}

	public double getC() {
		return c.getValue();
	}

	public Observable<Double> obsC() {
		return c.asObservable();
	}

	@Override
	public void onCompleted() {
		System.out.println("Completed...");
	}

	@Override
	public void onError(Throwable arg0) {
		System.out.println("Error...");
	}

	@Override
	public void onNext(Double arg0) {
		System.out.println("Next...");
	}
}