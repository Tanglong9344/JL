package java_collection;

/**
 * 检验数据的最大长度
 */

public class ArrayTest {

	public static void main(String[] args) {
		int[] intArr = new int[Integer.MAX_VALUE/15];
		System.err.println("长度:"+intArr.length);

		String[] StringArr = new String[Integer.MAX_VALUE/70];
		System.err.println("长度:"+StringArr.length);
	}
}
