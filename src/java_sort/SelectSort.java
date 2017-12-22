package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.Arrays;
import java.util.Random;

/**
 * ѡ������
 * ʱ�临�Ӷ�O(n2),�ռ临�Ӷ�O(1)
 *
 * @author ����
 */
public class SelectSort {
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
		//ѡ������
		selectSort(intArr);
		long end = System.nanoTime();
		System.out.printf("ѡ�����򹲺�ʱ%f����%n",(end-begin)/1.0);
		//ѡ�������
		System.out.println("ѡ�������:"+Arrays.toString(intArr));
	}

	//ѡ������ʵ�ַ���
	static void selectSort(int [] intArr){
		//����n-1�˲���
		for(int i=0,len = intArr.length,j,swap,minPos;i<len-1;i++){
			minPos=i;
			for(j=i+1;j<len;j++){
				//����
				if(intArr[j]<intArr[minPos]){
					minPos=j;
				}
			}
			//�Ƿ���Ҫ����
			if(minPos != i){
				swap=intArr[i];
				intArr[i]=intArr[minPos];
				intArr[minPos]=swap;
			}
			//��ʾÿ�˲����Ľ��
			System.out.printf("��%2d�˲���:%s%n",i+1,Arrays.toString(intArr));
		}
	}
}