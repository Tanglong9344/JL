package java_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList ��  LinkedList���ݶ�λ�Ա�
 * @author ����
 */
public class ArrayListLocationTest {
	public static void main(String[] args) {
		List<Integer> intList;
		intList = new ArrayList<>();
		modify(intList, "ArrayList");

		intList = new LinkedList<>();
		modify(intList, "LinkedList");
	}

	// ���Է���
	private static void modify(List<Integer> intList, String type) {
		int total = 100 * 1000;
		int index = total/2;
		final int number = 5;
		//��ʼ��
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
		System.out.printf("%s�ܳ�����%d����λ����%d�����ݣ�ȡ��������1���ٷŻ�ȥ%n �ظ�%d�飬�ܹ���ʱ %d ���� %n", type,total, index,total, end - start);
		System.out.println();
	}
}