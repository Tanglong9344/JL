package java_core_basic;

/**
 * 运算符优先级
 * @author 唐龙
 */
public class OperatorPriority {
	public static void main(String[] args) {
		int a = 0;
		System.out.println("a=" + a);
		int b = (a++) + (++a);
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		b += (++b);
		System.out.println("b=" + b);
		int c = (b>0)?b:++b;
		System.out.println("c=" + c);
	}
}