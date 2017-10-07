/**
 * Java 数组
 * 数组一旦创建，
 * 其中可以容纳的变量数目就被固定，
 * 无法根据具体需要动态改变。
 *
 * 而集合对象的容量可以根据需要自动扩展，
 * 集合只能容纳对象而不能容纳基本数据类型数据。
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
		System.out.println(Arrays.toString(intArr));
		//Sort
		Arrays.sort(intArr);
		//After sort
		System.out.print("After Sort:\n");
		System.out.println(Arrays.toString(intArr));

		//Binary search
		//param:数组
		//param:检索开始位置
		//param:检索结束位置
		//param:查找数值
		//找到则返回数值所在的最后一个位置，未找到则返回负数
		System.out.println(Arrays.binarySearch(intArr, 0,intArr.length,5));
	}
}