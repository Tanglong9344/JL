/**
 * Java ����
 */
package java_core_basic;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		//��������
		//���ݳ�ʼ��
		int[] intArr = new int[10];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = (int) (Math.random() * 10);
		}
		//Before sort
		System.out.print("Before Sort:\n");
		for (int var : intArr) {
			System.out.print(var + "\t");
		}
		System.out.println();
		//Sort
		Arrays.sort(intArr);

		//After sort
		System.out.print("After Sort:\n");
		for (int var : intArr) {
			System.out.print(var + "\t");
		}
		System.out.println();
		System.out.println("����.toString()" + intArr.toString());

		//Binary search
		//param:����
		//param:������ʼλ��
		//param:��������λ��
		//param:������ֵ
		//�ҵ�������ֵ���ڵ�λ�ã�δ�ҵ����ظ���
		System.out.println(Arrays.binarySearch(intArr, 0,intArr.length,5));
	}
}