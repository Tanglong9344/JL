package java_collection;

/**
 * �������ݵ���󳤶�
 */

public class ArrayTest {

	public static void main(String[] args) {
		int[] intArr = new int[Integer.MAX_VALUE/15];
		System.err.println("����:"+intArr.length);

		String[] StringArr = new String[Integer.MAX_VALUE/70];
		System.err.println("����:"+StringArr.length);
	}
}
