package java_recursion;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		System.out.println("请输入一个正整数：");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(num + "的阶乘为：" + recursiveFactorial(num));
	}

	//递归求阶乘
	//算法的本质是一系列有限操作的有序序列。
	static public int recursiveFactorial(int n){
		if(1 == n){
			return 1;
		}else{
			return n*recursiveFactorial(n-1);
		}
	}
}
