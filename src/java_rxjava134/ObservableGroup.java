package java_rxjava134;

import java.util.Arrays;
import java.util.List;

import rx.Observable;

/**
 * Observable group
 *
 * @author ÌÆÁú
 *
 */
public class ObservableGroup {
	public static void main(String[] args) {
		// groupBy
		List<String> names = Arrays.asList(
				"Bill Gates from Microsoft",
				"Steve Jobs from Apple",
				"The Moon Is So Bright",
				"Tanglong from China",
				"TomCat", "OctoCat"
				);
		testGroupBy(names);
		testGroupBy2(names);
	}

	/** Test for groupBy */
	private static <T> void testGroupBy(List<String> list) {
		Observable
		.from(list)
		.groupBy(e -> e.split(" ").length) // group the elements by it's length
		.subscribe(e -> Commons.subscribePrint(e, e.getKey() + " word(s)"));
	}

	/** Another test for groupBy */
	private static <T> void testGroupBy2(List<String> list) {
		Observable
		.from(list)
		.groupBy(
				e -> e.replaceAll("[^mM]", "").length(),
				e -> e.replaceAll("[mM]", "*")
				)
		.subscribe(e -> Commons.subscribePrint(e, e.getKey() + " Occurences of m"));
	}
}