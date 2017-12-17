package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.Arrays;
import java.util.Random;

/**
 * ��������
 * ƽ��ʱ�临�Ӷ�O(NlogN)���ʱ�临�Ӷ�O(N2)���ռ临�Ӷ�O(logN)
 *
 * @author ����
 */
public class QuickSort {
	private static int sum=0;//ͳ�Ʋ�������
	public static void main(String[] args) {
		int [] intArr = new int [LENGTH];
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//��������
		quickSort(intArr,0,intArr.length-1);
		long end = System.nanoTime();
		System.out.printf("�������򹲺�ʱ%f����%n",(end-begin)/1.0);
		//���������
		System.out.println("���������:"+Arrays.toString(intArr));
	}

	//��������ʵ�ַ���
	//���õݹ�˼��
	static void quickSort(int[] intArr,int start,int end){
		//������־
		if(start>=end){
			return;
		}
		//�������
		int low = start;//��λ
		int high = end;//��λ
		int key=intArr[start];//�Ե�һ����Ϊ�ο�ֵ
		while (low < high) {
			//�Ӹ�λ��ʼ�����Ƚ�
			//�������ڵ��ڲο�ֵ������
			while(low<high && intArr[high]>=key) {
				high--;
			}
			//С��key��ֵ�ƶ���key���
			intArr[low]=intArr[high];
			//����С�ڵ��ڲο�ֵ������
			while(low<high && intArr[low]<=key) {
				low++;
			}
			//����key��ֵ�ƶ���key�ұ�
			intArr[high]=intArr[low];
		}
		//���ο�ֵ�Ż�
		intArr[low]=key;
		//��ʾÿ������Ľ��
		sum++;
		System.out.printf("��%2d�β������:%s%n",sum,Arrays.toString(intArr));
		//�ݹ����
		//��벿��
		if(low>start) {
			quickSort(intArr, start, low-1);
		}
		//�Ұ벿��
		if(high<end) {
			quickSort(intArr, low+1, end);
		}
	}
}