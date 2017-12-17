package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.Arrays;
import java.util.Random;

/**
 * �鲢����
 * ʱ�临�Ӷ�O(NlogN),�ռ临�Ӷ�O(N)
 *
 * @author ����
 */
public class MergeSort {
	static int cnt = 0;//��¼��������
	public static void main(String[] args) {
		int [] intArr = new int [LENGTH];
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ    ��"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//�鲢����
		mergeSort(intArr,0,intArr.length-1);
		long end = System.nanoTime();
		System.out.printf("�鲢���򹲺�ʱ%f����%n",(end-begin)/1.0);
		//�鲢�����
		System.out.println("�鲢�����"+Arrays.toString(intArr));
	}

	//�ݹ�ʵ�ֹ鲢����
	public static void mergeSort(int[] data,int left,int right) {
		if(left<right){
			//����
			int center=(left+right)/2;
			//��ݹ�
			mergeSort(data,left,center);
			//�ҵݹ�
			mergeSort(data,center+1,right);
			//���Һϲ�
			merge(data,left,center,right);
		}
	}
	public static void merge(int[] data,int left,int center,int right) {
		int [] mergeArr=new int[data.length];//�ϲ�����
		int rightStart=center+1;//�ұ�������ʼλ��
		int index=left;//�ϲ�������ʼ����
		int iniPos=left;//��¼ԭ��������򲿷ֵ���ʼλ��
		while(left<=center&&rightStart<=right){
			//������������ȡ����С�ķ����м�����
			mergeArr[index++]=data[left]<=data[rightStart]?data[left++]:data[rightStart++];
		}
		//ʣ�ಿ�����η����м�����
		//�������
		while(left<=center){
			mergeArr[index++]=data[left++];
		}
		//�ұ�����
		while(rightStart<=right){
			mergeArr[index++]=data[rightStart++];
		}
		//���ϲ������е����ݸ��ƻ�ԭ����
		while(iniPos<=right){
			data[iniPos]=mergeArr[iniPos++];
		}
		//��ʾÿ�β����Ľ��
		cnt++;
		System.out.printf("��%2d������%s%n",cnt,Arrays.toString(data));
	}
}