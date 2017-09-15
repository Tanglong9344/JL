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
		System.out.println("\n基本类型强制转换");
		double db1 = 143.426d;
		System.out.println("db1 = "+db1);

		//将double类型强转成float
		float ff = (float) db1;
		System.out.println("ff = "+ff);

		//将double类型强转成long
		long ll = (long) db1;
		System.out.println("ll = "+ll);

		//将double类型强转成int
		int ii = (int) db1;
		System.out.println("ii = "+ii);

		//将double类型强转成short
		short s1 = (short) db1;
		System.out.println("s1 = "+s1);

		//将double类型强转成byte
		byte b1 = (byte) db1;
		System.out.println("b1 = "+b1);

		//String 转换 Integer,int
		System.out.println("\nString 转换 Integer,int:");
		String str = "123";
		System.out.println("str="+str);
		Integer integer = Integer.valueOf(str);
		System.out.println("integer="+integer);
		int intValue = Integer.valueOf(str).intValue();
		System.out.println("intValue="+intValue);
	}
}
