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
			intArr[i] = (int) (Math.random() * 100);
		}
		System.out.print("Before Sort:");
		for (int var : intArr) {
			System.out.print(var + "\t");
		}
		System.out.println();
		//����
		Arrays.sort(intArr);

		System.out.print("After Sort:");
		System.out.println();
		for (int var : intArr) {
			System.out.print(var + "\t");
		}
		System.out.println();
		System.out.println("����.toString()" + intArr.toString());
	}
}
