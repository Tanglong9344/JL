package java_core_basic;

public class ThrowsTest {
	public static void main(String[] args) {
		final int N = 100000;
		String str = "HelloolleH";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++)
			sb.append(str);
		System.out.println(sb.length());
		// System.out.println(sb.toString());
	}
}
