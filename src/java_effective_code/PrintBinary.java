package java_effective_code;

/**
 * Transform a number(int or long) to binary
 *
 * @author ÌÆÁú
 *
 */
public class PrintBinary {
	private static StringBuilder sb = null;
	/**int number*/
	public static void printBinaryInt(int a) {
		sb = new StringBuilder();
		for(int i=31;i>=0;i--) {
			if(((1 << i) & a) != 0) {
				sb.append("1");
			}else{
				sb.append("0");
			}
		}
		System.out.println(sb.toString());
	}

	/**long number*/
	public static void printBinaryLong(long a) {
		sb = new StringBuilder();
		for(int i=63;i>=0;i--) {
			if(((1 << i) & a) != 0) {
				sb.append("1");
			}else{
				sb.append("0");
			}
		}
		System.out.println(sb.toString());
	}
}