package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.Arrays;
import java.util.Random;

/**
 * ���ֲ�������
 * ʱ�临�Ӷ�O(n2),�ռ临�Ӷ�O(1)
 * �����һ��������򣬼����˱Ƚϴ������ƶ��������䡣
 *
 * @author ����
 */
public class BinaryInsertSort {
	public static void main(String[] args) {
		int [] intArr = new int [LENGTH];
		//�۰��������
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//�۰��������
		binaryInsertSort(intArr);
		long end = System.nanoTime();
		System.out.printf("�۰�������򹲺�ʱ%f����%n",(end-begin)/1.0);
		//�۰���������
		System.out.println("�۰���������:"+Arrays.toString(intArr));
	}
	//�۰��۰��������ʵ�ַ���
	static void binaryInsertSort(int[] intArr){
		int i,j;
		int len=intArr.length;
		int tmp,low,high,mid;
		for(i=1;i<len;i++){
			tmp=intArr[i];
			low = 0;
			high = i-1;
			//�۰���Ҳ���λ��
			while(low<=high){
				mid = (low+high)/2;
				if(tmp<intArr[mid]){
					high = mid-1;
				}else{
					low = mid+1;
				}
			}
			//�����ƶ�
			for(j=i-1;j>=high+1;j--){
				intArr[j+1]=intArr[j];
			}
			intArr[high+1]=tmp;
			//��ʾÿ�β����Ľ��
			System.out.printf("��%2d�β�����%s%n",i,Arrays.toString(intArr));
		}
	}
}