package something_interesting;

import java.util.Scanner;

public class PalindromeTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n;
		boolean yes = true;
		String judgeResult = "";
		System.out.println("������һ����������������ǻ�������������룩��");
		// ֱ�����������Ϊ���ģ�������ѭ��
		while (yes) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			yes = !isPalindrome(n);
			judgeResult = yes ? "���ǻ�������" : "�ǻ�������";
			System.out.printf("%d %s%n", n, judgeResult);
		}
	}

	// �������ж�
	public static boolean isPalindrome(int n) {
		int m = reverse(n);
		if (m == n) {
			return true;
		} else {
			return false;
		}
	}

	// ����������ֽ��е���
	public static int reverse(int num) {
		int s = num, j = 0;
		while (0 != s) {
			j = j * 10 + s % 10;
			s = s / 10;
		}
		return j;
	}
}