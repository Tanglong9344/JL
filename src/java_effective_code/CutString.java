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
	static final int LEN = 60;
	public static void main(String[] args) {
		String str = getString(LEN); // get a string that length is LEN
		//String str2 = UUID.randomUUID().toString(); // get a string using UUID.randomUUID()
		System.out.println("str: " + str);

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
	 * subString get a substring length is 1/5 of the length of string
	 *
	 * @param str
	 * @return
	 */
	private static String subString(String str) {
		Random r   = new Random();
		int len    = str.length();
		int subLen = len/5;
		int beginIndex = r.nextInt(len-subLen);
		return str.substring(beginIndex, beginIndex + subLen);
	}

	/**
	 * array copy get a substring length is 1/5 of the length of string
	 *
	 * @param str
	 * @return
	 */
	private static String arraycopy(String str) {
		Random r   = new Random();
		int len    = str.length();
		int subLen = len/5;
		int beginIndex = r.nextInt(len-(subLen));
		char[] subStr = new char[subLen];
		System.arraycopy(str.toCharArray(), beginIndex, subStr, 0, (subLen));
		return String.valueOf(subStr);
	}
}