package java_core_basic;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		//�������Math.Random()
		//Random()������Random�����nextDouble()����ʵ��
		System.out.println("Math.Random():");
		//���ֻ�ȡ�����ķ���Ч��Ҫ��Random�����nextInt()�����ͺܶ�
		for(int i=0;i<10;i++) {
			System.out.print("�����:"+(int)(Math.random()*10)+" ");
		}

		//�������java.util.random()
		Random rm = new Random();
		System.out.println("\njava.util.random()������:");
		for(int i=0;i<10;i++) {
			System.out.print("�����:"+ rm.nextInt(10)+" ");
		}

		System.out.println("\njava.util.random()��������:");
		for(int i=0;i<10;i++) {
			System.out.print("�����:"+ rm.nextFloat()+" ");
		}

		System.out.println("\njava.util.random()��������:");
		for(int i=0;i<10;i++) {
			System.out.print("�����:"+ rm.nextLong()+" ");
		}
	}
}