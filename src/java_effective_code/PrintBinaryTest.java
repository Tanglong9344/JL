package java_effective_code;

/**
 * PrintBinary Test
 *
 * @author ����
 *
 */
public class PrintBinaryTest {
	public static void main(String[] args) {
		int a    = 11;
		int aa   = -11;
		long al  = 11L;
		long aal = -11L;
		PrintBinary.printBinaryInt(a);
		PrintBinary.printBinaryInt(aa);
		PrintBinary.printBinaryLong(al);
		PrintBinary.printBinaryLong(aal);
	}
}