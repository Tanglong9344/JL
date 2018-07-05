package java_encoding;

/**
 * ascii(0-127) 码与字符间的转化
 * @author tanglong
 *
 */
public class ASCIIAndChar {
	public static void main(String[] args) {
		char[] cs = {'a','b','c','d','e','f'};

		Integer[] is = new Integer[cs.length];
		for(int i=0,len=cs.length;i<len;i++) {
			is[i] = charToAscii(cs[i]);
		}
		printArray(is);

		Character[] chs = new Character[cs.length];
		for(int i=0,len=is.length;i<len;i++) {
			chs[i] = asciiToChar(is[i]);
		}
		printArray(chs);
	}

	/** ascii to char */
	private static char asciiToChar(int a) {
		return (char)a;
	}

	/** char to ascii */
	private static int charToAscii(char c) {
		return c;
	}

	/** print array*/
	private static void printArray(Object[] os) {
		for(int i=0,len=os.length;i<len-1;i++) {
			System.out.print(os[i] + ",");
		}
		System.out.println(os[os.length-1]);
	}
}