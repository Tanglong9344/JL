package java_core_basic;

public class SystemTest {
	public static void main(String[] args) {
		//arraycopy()
		char[] charr2 = new char[] { 'ËÄ', '´ó', 'Ãû', 'Öí' };
		for (int i = 0; i < charr2.length; i++) {
			System.out.printf("charr2[%d]:%c%n", i, charr2[i]);
			if (i == charr2.length - 1) {
				System.out.println();
			}
		}
		char[] charr3 = new char[charr2.length];
		System.arraycopy(charr2, 0, charr3, 0, charr2.length);
		for (int i = 0; i < charr3.length; i++) {
			System.out.printf("charr3[%d]:%c%n", i, charr3[i]);
			if (i == charr3.length - 1) {
				System.out.println();
			}
		}
		//currentTimeMillis()
		System.out.println("MillisTime:" + System.currentTimeMillis());
		//nanoTime()
		System.out.println("nanoTime  :" + System.nanoTime());
	}
}
