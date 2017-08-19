package java_input_output;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("输入整数:"+sc.nextInt());
			System.out.println("输入二进制数:"+sc.nextByte());
			System.out.println("输入XX:"+sc.nextLine());
			System.out.println("输入双浮点数:"+sc.nextDouble());
			System.out.println("输入浮点数:"+sc.nextFloat());
			System.out.println("输入长整数:"+sc.nextLong());
		}
	}
}
