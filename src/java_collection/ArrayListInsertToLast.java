package java_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList 和  LinkedList在最后插入数据对比
 * @author 唐龙
 */
public class ArrayListInsertToLast {
	public static void main(String[] args) {
		List<Integer> intList;
		intList = new ArrayList<>();
		//ArrayList测试，易于定位数据
		insertFirst(intList, "ArrayList");

		intList = new LinkedList<>();
		//LinkedList测试，易于插入数据
		insertFirst(intList, "LinkedList");
	}

	// 测试方法
	private static void insertFirst(List<Integer> intList, String type) {
		int total = 100 * 1000;
		final int number = 5;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			intList.add(intList.size(), number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("在%s 最后面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
	}
}