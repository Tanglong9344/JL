package java_effective_code;

/**
 * String comparation
 *
 * @author ����
 *
 */
public class StringComparation {
	public static void main(String[] args) {
		// String����Ƚ�
		String o  = new String("110");
		String oo = new String("110");
		System.out.println(o.equals(oo)); // true
		System.out.println(o == oo);      // false

		// String ������
		String o1  = "110";
		String oo1 = "110";
		System.out.println(o1.equals(oo1)); // true
		System.out.println(o1 == oo1);      // true
	}
}