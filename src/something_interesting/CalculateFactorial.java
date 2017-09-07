package something_interesting;

import java.util.Scanner;

public class CalculateFactorial {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("请输入一个正整数：");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n;
		int j;

		//标号循环
		System.out.println("标号循环实现：");
		n = num;
		j=1;
		loop: while (true) {
			// 算阶层的具体实现
			n = n * (num - j);
			j++;
			if (j == num){
				break loop;
			}
		}
		System.out.println(num + "的阶乘为：" + n);

		System.out.println("while循环实现：");
		n = num;
		j=1;
		while (j != num) {
			// 算阶层的具体实现
			n = n * (num - j);
			j++;
		}
		System.out.println(num + "的阶乘为：" + n);

		System.out.println("for循环实现：");
		n = num;
		for(j=1;j<num-1;j++) {
			// 算阶层的具体实现
			n = n * (num - j);
		}
		System.out.println(num + "的阶乘为：" + n);

		System.out.println("递归实现：");
		System.out.println(num + "的阶乘为：" + recursive(num));
	}

	//递归求阶乘
	//算法的本质是一系列有限操作的有序序列。
	static public int recursive(int n){
		if(1 == n){
			return 1;
		}else{
			return n*recursive(n-1);
		}
	}
}