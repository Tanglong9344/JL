/**
 * ArrayList �� LinkedList �����������ݶԱ�
 */

package java_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListInsertToLast {
	public static void main(String[] args) {
		List<Integer> intList;
		intList = new ArrayList<>();
		//ArrayList���ԣ����ڶ�λ����
		insertFirst(intList, "ArrayList");

		intList = new LinkedList<>();
		//LinkedList���ԣ����ڲ�������
		insertFirst(intList, "LinkedList"); 
		}
		private static void insertFirst(List<Integer> intList, String type) {
		int total = 100 * 1000;
		final int number = 5;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			intList.add(intList.size(), number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("��%s ��������%d�����ݣ��ܹ���ʱ %d ���� %n", type, total, end - start);
	}
}
