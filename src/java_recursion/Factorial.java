package java_recursion;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		System.out.println("������һ����������");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(num + "�Ľ׳�Ϊ��" + recursiveFactorial(num));
	}

	//�ݹ���׳�
	//�㷨�ı�����һϵ�����޲������������С�
	static public int recursiveFactorial(int n){
		if(1 == n){
			return 1;
		}else{
			return n*recursiveFactorial(n-1);
		}
	}
}
