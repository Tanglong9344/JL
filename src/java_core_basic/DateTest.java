package java_core_basic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateTest {
	public static void main(String[] args) {
		//ʱ���ʽ��
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf3 = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();
		System.out.println("����:"+date);
		System.out.println("���ڸ�ʽ��1:"+sf1.format(date));
		System.out.println("���ڸ�ʽ��2:"+sf2.format(date));
		System.out.println("���ڸ�ʽ��3:"+sf3.format(date));
		System.out.println("���� System.currentTimeMillis()��"+System.currentTimeMillis());

		//�������Math.Random()
		System.out.println("Math.Random():");
		for(int i=0;i<10;i++) {
			System.out.print("�����:"+(int)(Math.random()*10)+" ");
		}

		//�������java.util.random()
		System.out.println("\njava.util.random():");
		for(int i=0;i<10;i++) {
			System.out.print("�����:"+ new Random().nextInt(10)+" ");
		}

		System.out.println("\njava.util.random(),������:");
		for(int i=0;i<10;i++) {
			System.out.print("�����:"+ new Random().nextFloat()+" ");
		}
		System.out.println("\njava.util.random()��������:");
		for(int i=0;i<10;i++) {
			System.out.print("�����:"+ new Random().nextLong()+" ");
		}
	}
}
