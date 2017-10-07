package java_generic;

import java.util.Arrays;

public class GenericMethod {

	public static void main(String[] args) {
		Integer[] intArr = {1,34,55,6,889,66,4};
		Float[] floatArr = {(float) 1.2,(float) 23,(float) 33};
		String [] stringArr = {"hello","你好","**&）（","EE"};
		Character[] cArr = {'x','6',',','O','?'};

		//使用泛型方法
		printArr(intArr);
		printArr(floatArr);
		printArr(stringArr);
		printArr(cArr);
	}
	//泛型方法
	private static <A> void printArr(A [] aArr){
		System.out.println(Arrays.toString(aArr));
	}
}
