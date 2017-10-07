package java_collection_map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = Collections.synchronizedList(list1);
	}
}
