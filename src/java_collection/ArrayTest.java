package java_collection;

import java.util.Arrays;
import java.util.Random;

/**
 * �������ݵ���󳤶�
 */

public class ArrayTest {

	public static void main(String[] args) {
		int[] intArr = new int[Integer.MAX_VALUE/15];
		System.err.println("����:"+intArr.length);

		String[] StringArr = new String[Integer.MAX_VALUE/70];
		System.err.println("����:"+StringArr.length);

		//sort()
		final int N = 10;
		int [] intArr2 = new int[N];
		Random rd = new Random();
		for(int i=0;i<N;i++){
			intArr2[i]=(rd.nextInt(100));
		}
		//����ǰ
		for(int i:intArr2){
			System.out.print(i+"  ");
		}
		System.out.println();
		//����
		Arrays.sort(intArr2);
		//�����
		for(int i:intArr2){
			System.out.print(i+"  ");
		}
		System.out.println();
	}
}