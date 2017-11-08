package java_log;

/**
 * Java 强大的的反向代理机制
 * @author 唐龙
 */
public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Test test = new Test();
		System.out.println(test.getClass());
		System.out.println(test.getClass().getName());
		System.out.println(test.getClass().getMethod("method"));
		Class<?>[] paras = {int.class};
		System.out.println(test.getClass().getMethod("method",paras));
		System.out.println(test.getClass().getClassLoader());
	}

	public void method(){};
	public void method(int i){};
}