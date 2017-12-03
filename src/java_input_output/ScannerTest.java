package java_input_output;

import java.util.Scanner;

/**
 * Scanner Test
 * @author 唐龙
 */
public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入整数:");
		System.out.println(sc.nextInt());
		System.out.println(sc.nextLine());//消去换行符

		System.out.println("输入二进制数:");
		System.out.println(sc.nextByte());
		System.out.println(sc.nextLine());

		System.out.println("输入字符串:");
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());

		System.out.println("输入双浮点数:");
		System.out.println(sc.nextDouble());
		System.out.println(sc.nextLine());

		System.out.println("输入浮点数:");
		System.out.println(sc.nextFloat());
		System.out.println(sc.nextLine());

		System.out.println("输入长整数:");
		System.out.println(sc.nextLong());
		System.out.println(sc.nextLine());

		sc.close();
	}
}