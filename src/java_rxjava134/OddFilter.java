package java_rxjava134;

import rx.Observable;
import rx.Observable.Transformer;

/**
 * Odd filter that implements Transformer
 *
 * @author ÌÆÁú
 *
 * @param <T>
 */
public class OddFilter<T> implements Transformer<T, T> {
	@Override
	public Observable<T> call(Observable<T> observable) {
		return observable
				.lift(new SelfDefinedOperator<T>(1L))
				.filter(pair -> pair.getLeft() % 2 == 1) // filter odd
				.map(pair -> pair.getRight()); // get result at the odd position
	}
}