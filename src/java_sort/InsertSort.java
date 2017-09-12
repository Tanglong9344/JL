package java_sort;

import java.util.Random;

public class InsertSort {
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
			System.out.print(i+" ");
		}
		System.out.println();
		long begin = System.nanoTime();
		//��������
		insertSort(intArr);
		long end = System.nanoTime();
		System.out.printf("�������򹲺�ʱ%f����%n",(end-begin)/10.0);
		//���������
		System.out.println("���������:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//��������ʵ�ַ���
	static void insertSort(int[] intArr){
		int i,j;
		int l=intArr.length;
		int tmp;
		for(i=1;i<l;i++){
			tmp=intArr[i];
			//�����ƶ�
			for(j=i-1;j>=0&&intArr[j]>tmp;j--){
				intArr[j+1]=intArr[j];
			}
			intArr[j+1]=tmp;
			//��ʾÿ�β����Ľ��
			System.out.printf("��%d�β�����%n",i);
			for(int v : intArr){
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}