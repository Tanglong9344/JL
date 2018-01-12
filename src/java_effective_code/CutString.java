package java_effective_code;

import static java_common.CommonUtils.getString;

import java.util.Random;

/***
 * ×Ö·û´®½ØÈ¡
 *
 * @author ÌÆÁú
 *
 */
public class CutString {
	static final int SIZE = 100;
	public static void main(String[] args) {
		String str = getString(SIZE); // get a string that length is SIZE
		//System.out.println("str: " + str);

		long start, end;
		final int LOOP_TIME = 3;

		// substring
		start = System.nanoTime();
		for(int i=0;i<LOOP_TIME;i++) {
			System.out.println(subString(str));
		}
		end = System.nanoTime();
		long tmp = end-start;

		// array copy
		start = System.nanoTime();
		for(int i=0;i<LOOP_TIME;i++) {
			System.out.println(arraycopy(str));
		}
		end = System.nanoTime();

		// results
		System.out.printf("Substring  loop for %d times, cost %d ns%n", LOOP_TIME, tmp);
		System.out.printf("Array copy loop for %d times, cost %d ns%n", LOOP_TIME, (end-start));

	}

	/**
	 * subString get a substring length is 10
	 *
	 * @param str
	 * @return
	 */
	private static String subString(String str) {
		Random r = new Random();
		int beginIndex = r.nextInt(SIZE-10);
		return str.substring(beginIndex, beginIndex + 10);
	}

	/**
	 * array copy get a substring length is 10
	 *
	 * @param str
	 * @return
	 */
	private static String arraycopy(String str) {
		Random r = new Random();
		int beginIndex = r.nextInt(SIZE-10);
		char[] subStr = new char[10];
		System.arraycopy(str.toCharArray(), beginIndex, subStr, 0, 10);
		return String.valueOf(subStr);
	}
}