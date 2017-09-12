package java_sort;

import java.util.Random;

public class BubbleSort {
	public static void main(String[] args) {
		final int LENGTH=10;//���鳤��
		final int RANGE =100;//���ݷ�Χ
		int [] intArr = new int [LENGTH];
		//ð������1
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
		//ð������1
		bubbleSort1(intArr);
		long end = System.nanoTime();
		System.out.printf("ð������1����ʱ%f����%n",(end-begin)/10.0);
		//ð������1������
		System.out.println("ð������1��:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();

		//ð������2
		//���ݳ�ʼ��
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//����ǰ
		System.out.println("����ǰ:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
		begin = System.nanoTime();
		//ð������2
		bubbleSort2(intArr);
		end = System.nanoTime();
		System.out.printf("ð������2����ʱ%f����%n",(end-begin)/10.0);
		//ð������2������
		System.out.println("ð������2��:");
		for(int i : intArr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	//ð������ʵ�ַ���1
	static void bubbleSort1(int [] intArr){
		int i,j,swap;
		int l=intArr.length;
		boolean stop = false;//����Ѿ�������ֹͣ����
		//����n-1�˲���
		for(i=0;i<l-1&&!stop;i++){
			stop=true;
			for(j=l-1;j>i;j--){
				//����
				if(intArr[j]<intArr[j-1]){
					stop=false;
					swap=intArr[j];
					intArr[j]=intArr[j-1];
					intArr[j-1]=swap;
				}
			}
		}
		System.out.printf("������%d�˲���%n",i);
	}

	//ð������ʵ�ַ���2
	static void bubbleSort2(int [] intArr){
		int i,j,swap;
		int l=intArr.length;
		boolean stop = false;//����Ѿ�������ֹͣ����
		//����n-1�˲���
		for(i=0;i<l-1&&!stop;i++){
			stop=true;
			for(j=0;j<l-i-1;j++){
				//����
				if(intArr[j]>intArr[j+1]){
					swap=intArr[j];
					intArr[j]=intArr[j+1];
					intArr[j+1]=swap;
					stop=false;
				}
			}
		}
		System.out.printf("������%d�˲���%n",i);
	}
}