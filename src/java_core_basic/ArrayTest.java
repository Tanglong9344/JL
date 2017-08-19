/**
 * Java 数组
 */
package java_core_basic;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		//整型数组
		//数据初始化
		int[] intArr = new int[10];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = (int) (Math.random() * 100);
		}
		System.out.print("Before Sort:");
		for (int var : intArr) {
			System.out.print(var + "\t");
		}
		System.out.println();
		//排序
		Arrays.sort(intArr);

		System.out.print("After Sort:");
		System.out.println();
		for (int var : intArr) {
			System.out.print(var + "\t");
		}
		System.out.println();
		System.out.println("数组.toString()" + intArr.toString());
	}
}
