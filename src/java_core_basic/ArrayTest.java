/**
 * Java ����
 * ����һ��������
 * ���п������ɵı�����Ŀ�ͱ��̶���
 * �޷����ݾ�����Ҫ��̬�ı䡣
 *
 * �����϶�����������Ը�����Ҫ�Զ���չ��
 * ����ֻ�����ɶ�����������ɻ��������������ݡ�
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
		System.out.println(Arrays.toString(intArr));
		//Sort
		Arrays.sort(intArr);
		//After sort
		System.out.print("After Sort:\n");
		System.out.println(Arrays.toString(intArr));

		//Binary search
		//param:����
		//param:������ʼλ��
		//param:��������λ��
		//param:������ֵ
		//�ҵ��򷵻���ֵ���ڵ����һ��λ�ã�δ�ҵ��򷵻ظ���
		System.out.println(Arrays.binarySearch(intArr, 0,intArr.length,5));
	}
}