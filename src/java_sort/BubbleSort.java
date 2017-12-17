package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.Arrays;
import java.util.Random;

/**
 * ð������
 * ʱ�临�Ӷ�O(n2),�ռ临�Ӷ�O(1)
 *
 * @author ����
 */
public class BubbleSort {
	public static void main(String[] args) {
		int [] intArr = new int [LENGTH];
		//ð������1
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:"+Arrays.toString(intArr));

		long begin = System.nanoTime();
		//ð������1
		bubbleSort1(intArr);
		long end = System.nanoTime();
		System.out.printf("ð������1����ʱ%f����%n",(end-begin)/1.0);
		//ð������1������
		System.out.println("ð������1��:"+Arrays.toString(intArr));

		//ð������2
		//���ݳ�ʼ��
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:"+Arrays.toString(intArr));
		begin = System.nanoTime();
		//ð������2
		bubbleSort2(intArr);
		end = System.nanoTime();
		System.out.printf("ð������2����ʱ%f����%n",(end-begin)/10.0);
		//ð������2������
		System.out.println("ð������2��:"+Arrays.toString(intArr));
	}
	//ð������ʵ�ַ���1
	static void bubbleSort1(int [] intArr){
		int i,j;
		int len=intArr.length;
		//����n-1�˲���
		for(i=0;i<len-1;i++){
			for(j=len-1;j>i;j--){
				//����
				if(intArr[j]<intArr[j-1]){
					swap(intArr,j,j-1);//����
				}
			}
			//��ʾÿ�˲����Ľ��
			System.out.printf("��%2d�˲���:%s%n",i+1,Arrays.toString(intArr));
		}
	}

	//ð������ʵ�ַ���2����ʵ�ַ���1�Ļ������������ж�
	static void bubbleSort2(int [] intArr){
		int i,j;
		int len=intArr.length;
		boolean stop = false;//����Ѿ�������ֹͣ����
		//����n-1�˲���
		for(i=0;i<len-1&&!stop;i++){
			stop=true;
			for(j=0;j<len-i-1;j++){
				//����
				if(intArr[j]>intArr[j+1]){
					swap(intArr,j,j+1);//����
					stop=false;
				}
			}
			//��ʾÿ�˲����Ľ��
			System.out.printf("��%2d�˲���:%s%n",i+1,Arrays.toString(intArr));
		}
	}

	// ��������
	static void swap(int[] arr,int i,int j){
		int tmp;
		tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}