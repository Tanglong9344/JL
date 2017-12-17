package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.Arrays;
import java.util.Random;

/**
 * ������
 * �������£�ʱ�临�Ӷ�O(NlogN)���ռ临�Ӷ�O(1)
 *
 * ʵʩ���̣�
 * 1���½���
 * 2������Ԫ��
 * 3���ؽ���
 *
 * ʹ��һά����洢������
 * ���нڵ�i�����ӽڵ�Ϊ2i+1,���ӽڵ�Ϊ2i+2
 *
 * @author ����
 */
public class HeapSort {
	public static void main(String[] args) {
		int [] intArr = new int [LENGTH];
		//������
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//������
		heapSort(intArr);
		long end = System.nanoTime();
		System.out.printf("�����򹲺�ʱ%f����%n",(end-begin)/1.0);
		//�����������
		System.out.println("�������:"+Arrays.toString(intArr));
	}

	public static  void heapSort(int[] arr){
		int len=arr.length;
		//ѭ������
		for(int i=1;i<len;i++){
			//����
			buildMaxHeap(arr,len-i);
			System.out.printf("��%2d�ν����󶥶�    :%s%n",i,Arrays.toString(arr));
			//�����Ѷ�������i��Ԫ��
			swap(arr,0,len-i);
			System.out.printf("��%2d�ν����Ѷ�Ԫ��:%s%n",i,Arrays.toString(arr));
		}
	}
	//�������0��len���󶥶�
	private static void buildMaxHeap(int[]arr, int len) {
		int i,k,big;
		//�����һ���ڵ�ĸ��ڵ㿪ʼ
		for(i=(len-1)/2;i>=0;i--){
			//k���������жϵĽڵ�
			k=i;
			//�����ǰk�ڵ���ӽڵ����
			if(k*2+1<=len){
				//k�ڵ�����ӽڵ������
				big=k*2+1;
				//���bigС��len����big+1�����k�ڵ�����ӽڵ����
				if(big<len){
					//�������ӽڵ��ֵ�ϴ�
					if(arr[big]<arr[big+1]){
						//big���Ǽ�¼�ϴ��ӽڵ������
						big=big+1;
					}
				}
				//���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
				if(arr[k]<arr[big]){
					swap(arr,k,big);//����
				}
			}
		}
	}

	//��������
	private static  void swap(int[] arr, int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}