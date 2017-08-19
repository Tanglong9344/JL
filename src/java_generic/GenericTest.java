package java_generic;

public class GenericTest {

	public static void main(String[] args) {
		Integer[] intArr = {1,34,55,6,889,66,4};
		Float[] floatArr = {(float) 1.2,(float) 23,(float) 33};
		String [] stringArr = {"hello","���","**&����","EE"};
		Character[] cArr = {'x','6',',','O','?'};
		printArr(intArr);
		printArr(floatArr);
		printArr(stringArr);
		printArr(cArr);
	}
	//���ͷ���
	public static <A> void printArr(A [] aArr){
		for(A a:aArr) {
			System.out.print(a+"   ");
		}
		System.out.println();
	}
}
