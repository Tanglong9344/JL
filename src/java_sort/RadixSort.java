package java_sort;

import static java_sort.CommonConstants.LENGTH;
import static java_sort.CommonConstants.RANGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * ��������
 * ʱ�临�Ӷ�O(d(N+rd))=O(d.N),�ռ临�Ӷ�O(rd)
 * d:�ؼ�����Ŀ��rd�ؼ���ȡֵ��Χ
 *
 * ������������:���ݷ��䣬�����ռ���
 * @author ����
 */
public class RadixSort {
	public static void main(String[] args) {
		int [] intArr = new int [LENGTH];
		//���ݳ�ʼ��
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ        ��"+Arrays.toString(intArr));
		long begin = System.nanoTime();
		//��������
		radixSort(intArr);
		long end = System.nanoTime();
		System.out.printf("�������򹲺�ʱ%f����%n",(end-begin)/1.0);
		//���������
		System.out.println("���������"+Arrays.toString(intArr));
	}

	//��������ʵ�ַ���
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void radixSort(int[] arr){
		//����ȷ�����������;
		//�ҳ����ֵ
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		int time=0;//��¼�������λ��
		//λ��ͳ��;
		while(max>0){
			max/=10;
			time++;
		}
		//����10�����У��ֱ����ڴ洢����λ������Ϊ0-9������
		List<ArrayList> lists=new ArrayList<ArrayList>();
		ArrayList<Integer> list = null;//�����ݴ�����
		for(int i=0;i<10;i++){
			list=new ArrayList<Integer>();
			lists.add(list);
		}
		int i,j,x,k,cnt;
		//����time�η�����ռ�;
		for(i=1;i<=time;i++){
			//��������Ԫ��;
			for(j=0;j<arr.length;j++){
				//�õ����ֵĵ�timeλ��;
				x=(arr[j]%(int)Math.pow(10,i))/(int)Math.pow(10,i-1);
				list=lists.get(x);
				list.add(arr[j]);
			}
			//��ʾÿ�β������
			System.out.printf("��%2d������%s%n",i,lists);
			cnt=0;//Ԫ�ؼ�����;
			//�ռ�����Ԫ��;
			for(k=0;k<10;k++){
				list=lists.get(k);
				while(list.size()>0){
					arr[cnt]=list.get(0);
					list.remove(0);
					cnt++;
				}
			}
		}
	}
}