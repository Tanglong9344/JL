package java_sort;

import java.util.Random;

public class QuickSort {
	private static int sum=0;//ͳ�Ʋ�������
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
		//��������
		quickSort(intArr,0,intArr.length-1);
		//���������
		System.out.println("���������:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//��������ʵ�ַ���
	//���õݹ�˼��
	static void quickSort(int[] intArr,int start,int end){
		//������־
		if(start>=end){
			return;
		}
		//�������
		int l = start;//��λ
		int h = end;//��λ
		int key=intArr[start];//�Ե�һ����Ϊ�ο�ֵ
		int swap;
		while (l < h) {
			//�Ӹ�λ��ʼ�����Ƚ�
			//�������ڵ��ڲο�ֵ������
			while(l<h && intArr[h]>=key) {
				h--;
			}
			if (l<h) {
				swap=intArr[h];
				intArr[h]=intArr[l];
				intArr[l]=swap;
				l++;
			}

			//����С�ڵ��ڲο�ֵ������
			while(l<h && intArr[l]<=key) {
				l++;
			}
			if(l<h){
				swap=intArr[l];
				intArr[l]=intArr[h];
				intArr[h]=swap;
				h--;
			}
		}
		sum++;
		System.err.printf("��%d�β������:%n",sum);
		for(int v : intArr){
			System.out.print(v+" ");
		}
		System.out.println("");
		//��������
		if(l>start) {
			quickSort(intArr, start, l-1);
		}
		if(h<end) {
			quickSort(intArr, l+1, end);
		}
	}
}