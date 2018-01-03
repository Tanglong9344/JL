package bit_operation;

/**
 * 位运算
 *
 * @author 唐龙
 */
public class BitOperation{
	public static void main(String[] args) {
		// bit operation
		int a = 8;
		System.out.println(a<<2);//左移
		System.out.println(a>>2);//右移
		System.out.println(a>>>2);//无符号右移
		System.out.println(a^2);//异或
		System.out.println(a&2);//与
		System.out.println(a|2);//或
		System.out.println(~a);//非

		// combination operators
		a = 8;
		a<<=2;
		System.out.println(a);
		a>>=2;
		System.out.println(a);
		a>>>=2;
		System.out.println(a);
		a^=2;
		System.out.println(a);
		a&=2;
		System.out.println(a);
		a|=2;
		System.out.println(a);
	}
}