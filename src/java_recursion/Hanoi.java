package java_recursion;
/**
 * ������A�ϵ�n����Ƭ˳�򲻱���ƶ�������C
 */

import java.util.Scanner;

public class Hanoi {
	public static void main(String[] args) {
		int num;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ�ƶ��Ŀ�Ƭ��Ŀ��");
		num = scanner.nextInt();
		hanoi('A','C','B',num);
	}

	/**
	 * ��ŵ���ƶ�����
	 */
	static void hanoi(char from,char to,char temp,int n){
		if(1 == n){
			System.out.println(from + " move to " + to);
		}else{
			hanoi(from,temp,to,n-1);
			System.out.println(from + " move to " + to);
			hanoi(temp,to,from,n-1);
		}
	}
}