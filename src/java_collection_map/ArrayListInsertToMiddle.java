package java_collection_map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList �� LinkedList ���м�������ݶԱ�
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
		System.out.printf("��%s �м����%d�����ݣ��ܹ���ʱ %d ���� %n", type, total, end - start);
	}
}
