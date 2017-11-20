package java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOperations {
	public static void main(String[] args) {
		final int N = 8;
		//初始化集合
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			numbers.add((int)(Math.random()*30));
		}
		System.out.println("集合中的数据:");
		System.out.println(numbers);

		Collections.reverse(numbers);
		System.out.println("翻转后集合中的数据:");
		System.out.println(numbers);

		Collections.shuffle(numbers);
		System.out.println("混淆后集合中的数据:");
		System.out.println(numbers);

		Collections.sort(numbers);
		System.out.println("排序后集合中的数据:");
		System.out.println(numbers);

		Collections.swap(numbers,0,5);
		System.out.println("交换0和5下标的数据后，集合中的数据:");
		System.out.println(numbers);

		Collections.rotate(numbers,2);
		System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
		System.out.println(numbers);

		int size = numbers.size();
		System.out.println("集合大小:"+size);

		System.out.println("把非线程安全的List转换为线程安全的List");
		List<Integer> synchronizedNumbers = Collections.synchronizedList(numbers);
		System.out.println(synchronizedNumbers);
	}
}