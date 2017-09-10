package java_sort;

import java.util.Random;

public class QuickSort {
	public static void main(String[] args) {
		final int LENGTH=10;//数组长度
		final int RANGE =100;//数据范围
		int [] intArr = new int [LENGTH];
		//数据初始化
		Random rd = new Random();
		for(int i=0;i<LENGTH;i++){
			intArr[i]=rd.nextInt(RANGE);
		}
		//排序前
		System.out.println("排序前:");
		for(int i : intArr){
			System.out.println(i);
		}
		System.out.println();
		//快速排序
		intArr = quickSort(intArr);
		//快速排序后
		System.out.println("快速排序后:");
		for(int i : intArr){
			System.out.println(i);
		}
		System.out.println();
	}
	//快速排序实现方法
	//采用递归思想
	static int[] quickSort(int [] intArr){

		return intArr;
	}
}
