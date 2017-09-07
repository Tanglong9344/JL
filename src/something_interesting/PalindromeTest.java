package something_interesting;

import java.util.Scanner;

public class PalindromeTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n;
		boolean yes = true;
		String judgeResult = "";
		System.out.println("请输入一个回文数（如果不是回文数则继续输入）：");
		// 直到输入的数字为回文，才跳出循环
		while (yes) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			yes = !isPalindrome(n);
			judgeResult = yes ? "不是回文数。" : "是回文数。";
			System.out.printf("%d %s%n", n, judgeResult);
		}
	}

	// 回文数判断
	public static boolean isPalindrome(int n) {
		int m = reverse(n);
		if (m == n) {
			return true;
		} else {
			return false;
		}
	}

	// 将输入的数字进行倒置
	public static int reverse(int num) {
		int s = num, j = 0;
		while (0 != s) {
			j = j * 10 + s % 10;
			s = s / 10;
		}
		return j;
	}
}