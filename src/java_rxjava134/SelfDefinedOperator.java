package java_rxjava134;

import rx.Observable.Operator;
import rx.Subscriber;

/**
 * define a new Operator
 *
 * @author ÌÆÁú
 *
 * @param <T>
 */
public class SelfDefinedOperator<T> implements Operator<Pair<Long, T>, T>{
	private final long initialIndex;
	public SelfDefinedOperator() {
		this(0L);
	}

	public SelfDefinedOperator(long initial) {
		this. initialIndex = initial;
	}

	@Override
	public Subscriber<? super T> call(Subscriber<? super Pair<Long, T>> s) {
		return new Subscriber<T>(s) {
			private long index = initialIndex;
			@Override
			public void onCompleted() {
				s.onCompleted();
			}

			@Override
			public void onError(Throwable e) {
				s.onError(e);
			}

			@Override
			public void onNext(T t) {
				s.onNext(new Pair<Long, T>(index++, t));
			}
		};
	}
}