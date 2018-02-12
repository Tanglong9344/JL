package java_rxjava134;

/**
 * @author ÌÆÁú
 *
 * @param <L>
 * @param <R>
 */
public class Pair<L, R> {
	final L left;
	final R right;
	public Pair(L left, R right) {
		this.left  = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}

	@Override
	public String toString() {
		return String.format("%s : %s", this.left, this.right);
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Pair) {
			@SuppressWarnings("unchecked")
			Pair<L, R> p = (Pair<L, R>) o;
			return left.equals(p.left) && right.equals(p.right);
		}
		return false;
	}
}