package java_sort;

import java.util.Random;

public class SelectSort {
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
		//冒泡排序
		intArr = selectSort(intArr);
		//冒泡排序后
		System.out.println("选择排序后:");
		for(int i : intArr){
			System.out.println(i);
		}
		System.out.println();
	}
	//选择排序实现方法
	static int[] selectSort(int [] intArr){
		int i,j,swap;
		int l=intArr.length;
		int minPos;//记录某一趟操作下的最小值位置
		//进行n-1趟操作
		for(i=0;i<l-1;i++){
			minPos=i;
			for(j=i+1;j<l;j++){
				//升序
				if(intArr[j]<intArr[minPos]){
					minPos=j;
				}
			}
			//是否需要交换
			if(minPos != i){
				swap=intArr[i];
				intArr[i]=intArr[minPos];
				intArr[minPos]=swap;
			}
		}
		System.out.printf("共进行%d趟操作%n",i);
		return intArr;
	}
}