package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.Arrays;
import java.util.Random;

/**
 * һ���������
 * ʱ�临�Ӷ�O(n2),�ռ临�Ӷ�O(1)
 *
 * @author ����
 */
public class InsertSort {
	public static void main(String[] args) {
		int [] intArr = new int [LENGTH];
		//��������
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//��������
		insertSort(intArr);
		long end = System.nanoTime();
		System.out.printf("�������򹲺�ʱ%f����%n",(end-begin)/1.0);
		//���������
		System.out.println("���������:"+Arrays.toString(intArr));
	}

	//��������ʵ�ַ���
	static void insertSort(int[] intArr){
		int i,j;
		int len=intArr.length;
		int tmp;
		for(i=1;i<len;i++){
			tmp=intArr[i];
			//�����ƶ�
			for(j=i-1;j>=0&&intArr[j]>tmp;j--){
				intArr[j+1]=intArr[j];
			}
			intArr[j+1]=tmp;
			//��ʾÿ�β����Ľ��
			System.out.printf("��%2d�β�����%s%n",i,Arrays.toString(intArr));
		}
	}
}