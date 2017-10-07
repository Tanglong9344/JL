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
			intArr[i] = (int) (Math.random() * 10);
		}
		//Before sort
		System.out.print("Before Sort:\n");
		for (int var : intArr) {
			System.out.print(var + "\t");
		}
		System.out.println();
		//Sort
		Arrays.sort(intArr);

		//After sort
		System.out.print("After Sort:\n");
		for (int var : intArr) {
			System.out.print(var + "\t");
		}
		System.out.println();
		System.out.println("数组.toString()" + intArr.toString());

		//Binary search
		//param:数组
		//param:检索开始位置
		//param:检索结束位置
		//param:查找数值
		//找到返回数值所在的位置，未找到返回负数
		System.out.println(Arrays.binarySearch(intArr, 0,intArr.length,5));
	}
}