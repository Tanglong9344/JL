package java_collection_map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList 和 LinkedList 在中间插入数据对比
 */

public class ArrayListInsertToMiddle {
	public static void main(String[] args) {
		List<Integer> intList;
		intList = new ArrayList<>();
		insertFirst(intList, "ArrayList");

		intList = new LinkedList<>();
		insertFirst(intList, "LinkedList");
	}
	private static void insertFirst(List<Integer> intList, String type) {
		int total = 100 * 1000;
		final int number = 5;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			intList.add(intList.size()/2, number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("在%s 中间插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
	}
}
