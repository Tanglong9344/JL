package java_input_output;

import java.util.Scanner;

/**
 * Scanner Test
 * @author ����
 */
public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������:");
		System.out.println(sc.nextInt());
		System.out.println(sc.nextLine());//��ȥ���з�

		System.out.println("�����������:");
		System.out.println(sc.nextByte());
		System.out.println(sc.nextLine());

		System.out.println("�����ַ���:");
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());

		System.out.println("����˫������:");
		System.out.println(sc.nextDouble());
		System.out.println(sc.nextLine());

		System.out.println("���븡����:");
		System.out.println(sc.nextFloat());
		System.out.println(sc.nextLine());

		System.out.println("���볤����:");
		System.out.println(sc.nextLong());
		System.out.println(sc.nextLine());

		sc.close();
	}
}