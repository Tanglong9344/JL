package java_sort;

import java.util.Random;

public class ShellSort {
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
		long begin = System.nanoTime();
		//ϣ������
		shellSort(intArr);
		long end = System.nanoTime();
		System.out.printf("ϣ�����򹲺�ʱ%f����%n",(end-begin)/10.0);
		//ϣ�������
		System.out.println("ϣ�������:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//ϣ������ʵ�ַ���
	static void shellSort(int[] intArr){
		int i,j,k;
		int len=intArr.length;
		double len2 = intArr.length;
		len2=Math.ceil(len2);
		int tmp;
		//���鳤��Ϊ1ʱ��ֹ����
		while(1 != (len=(int)len2)){
			len2=Math.ceil(len2/2);
			//��������ʹ�ò�������
			for(k=0;k<len;k++){
				for(i=k+len;i<intArr.length;i+=len){
					tmp=intArr[i];
					for(j=i-len;j>=0&&tmp<intArr[j];j-=len){
						intArr[j+len]=intArr[j];
					}
					intArr[j+len]=tmp;
					//��ʾÿ�β����Ľ��
					System.out.printf("��%d�������������%n",len);
					for(int v : intArr){
						System.out.print(v+" ");
					}
					System.out.println();
				}
			}
		}
	}
}