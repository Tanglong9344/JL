package java_input_output;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("��������:"+sc.nextInt());
			System.out.println("�����������:"+sc.nextByte());
			System.out.println("����XX:"+sc.nextLine());
			System.out.println("����˫������:"+sc.nextDouble());
			System.out.println("���븡����:"+sc.nextFloat());
			System.out.println("���볤����:"+sc.nextLong());
		}
	}
}
