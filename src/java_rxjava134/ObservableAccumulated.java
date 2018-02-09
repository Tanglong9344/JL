package java_rxjava134;

import rx.Observable;

/**
 * Observable accumulated
 *
 * add or concatenate all the items one by one
 *
 * @author ÌÆÁú
 *
 */
public class ObservableAccumulated {
	public static void main(String[] args) {
		// scan
		testScan();
		// reduce
		testReduce();
	}

	/** test for 'scan' */
	private static void testScan() {
		Observable<Integer> scan = Observable
				.range(1, 3)
				.scan((p, v) -> p + v);
		Commons.subscribePrint(scan, "ScanSum");
		Commons.subscribePrint(scan.last(), "ScanFinal sum");
	}

	/** test for 'reduce' which is an alias of 'scan(Function).last()' */
	private static void testReduce() {
		Observable<Integer> scan = Observable
				.range(1, 3)
				.reduce((p, v) -> p + v);
		Commons.subscribePrint(scan, "ReduceSum");
	}
}