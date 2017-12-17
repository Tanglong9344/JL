package java_generic;

/**
 * 泛型类
 * @author 唐龙
 * @param <T>
 * @param <V>
 */
public class GenericClass<T,V> {
	public static void main(String args[]) {
		// 指定类型参数的实际类型
		GenericClass<Integer,Double> tv= new GenericClass<Integer,Double>(100,12.56);
		tv.printTypes();
		System.out.println("T变量中的值为:" + tv.getT());
		System.out.println("V变量中的值为:" + tv.getV());
	}

	private T t;
	private V v;

	/**Constructor*/
	GenericClass(T t1, V v1) {
		t = t1;
		v = v1;
	}

	/**Print type information*/
	void printTypes() {
		System.out.println("参数T的对象类型为:" + t.getClass().getName());
		System.out.println("参数V的对象类型为:" + v.getClass().getName());
	}

	T getT() {
		return t;
	}

	V getV() {
		return v;
	}
}