package java_sort;

import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		final int LENGTH=10;//���鳤��
		final int RANGE =100;//���ݷ�Χ
		int [] intArr = new int [LENGTH];
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:");
		for(int i : intArr){
			System.out.println(i);
		}
		System.out.println();
		//��������
		intArr = quickSort(intArr);
		//���������
		System.out.println("���������:");
		for(int i : intArr){
			System.out.println(i);
		}
		System.out.println();
	}
	//��������ʵ�ַ���
	//���õݹ�˼��
	static int[] quickSort(int [] intArr){

		return intArr;
	}
}
