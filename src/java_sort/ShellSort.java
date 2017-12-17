package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.Arrays;
import java.util.Random;

/**
 * ϣ������
 * ʱ�临�Ӷ�<O(n2),�ռ临�Ӷ�O(1)
 *
 * @author ����
 */
public class ShellSort {
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
		//ϣ������
		shellSort(intArr);
		long end = System.nanoTime();
		System.out.printf("ϣ�����򹲺�ʱ%f����%n",(end-begin)/1.0);
		//ϣ�������
		System.out.println("ϣ�������:"+Arrays.toString(intArr));
	}
	//ϣ������ʵ�ַ���
	static void shellSort(int[] intArr){
		int i,j,k;
		int len=intArr.length;
		int gap=len;//ÿ������������
		int tmp;
		//���鳤��Ϊ1ʱ��ֹ����
		while(gap>1){
			//��������
			gap=(int) Math.ceil(gap/2);
			//��������ʹ�ò�������
			for(k=0;k<gap;k++){
				for(i=k+gap;i<intArr.length;i+=gap){
					tmp=intArr[i];
					//�ƶ�
					for(j=i-gap;j>=k&&tmp<intArr[j];j-=gap){
						intArr[j+gap]=intArr[j];
					}
					//����
					intArr[j+gap]=tmp;
				}
			}
			//��ʾÿ�β����Ľ��
			System.out.printf("��%2d�������������%s%n",gap,Arrays.toString(intArr));
		}
	}
}