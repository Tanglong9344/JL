package java_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList 和  LinkedList数据定位对比
 * @author 唐龙
 */
public class ArrayListLocationTest {
	public static void main(String[] args) {
		List<Integer> intList;
		intList = new ArrayList<>();
		modify(intList, "ArrayList");

		intList = new LinkedList<>();
		modify(intList, "LinkedList");
	}

	// 测试方法
	private static void modify(List<Integer> intList, String type) {
		int total = 100 * 1000;
		int index = total/2;
		final int number = 5;
		//初始化
		for (int i = 0; i < total; i++) {
			intList.add(number);
		}
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			int n = intList.get(index);
			n++;
			intList.set(index, n);
		}
		long end = System.currentTimeMillis();
		System.out.printf("%s总长度是%d，定位到第%d个数据，取出来，加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒 %n", type,total, index,total, end - start);
		System.out.println();
	}
}