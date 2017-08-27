package java_core_basic;

/*
 * 基本类型转换
 */

public class BasicTypeChangeTest {
	public static void main(String[] args) {
		//基本类型自动转换
		System.out.println("基本类型自动转换");
		char c = 'a';
		System.out.println("c="+c);

		byte b = 44;
		System.out.println("b="+b);


		short s = b;
		System.out.println("s="+s);

		int i = s;
		System.out.println("i="+i);

		int i1 = c;
		System.out.println("i1="+i1);

		long l = i;
		System.out.println("l="+l);

		float f = l;
		System.out.println("f="+f);

		double d = f;
		System.out.println("d="+d);

		float f1 = 1.7f;
		System.out.println("f1="+f1);

		double db = f1;
		System.out.println("db="+db);

		f1 = (float) db;
		System.out.println("f1 = "+f1);

		// 基本类型强制转换
		System.out.println("\n\n基本类型强制转换");
		double db1 = 143.426d;
		System.out.println("db1 = "+db1);

		float ff = (float) db1;//将double类型强转成float
		System.out.println("ff = "+ff);

		long ll = (long) db1;//将double类型强转成long
		System.out.println("ll = "+ll);

		int ii = (int) db1;//将double类型强转成int
		System.out.println("ii = "+ii);

		short s1 = (short) db1;//将double类型强转成short
		System.out.println("s1 = "+s1);

		byte b1 = (byte) db1;//将double类型强转成byte
		System.out.println("b1 = "+b1);
	}
}
