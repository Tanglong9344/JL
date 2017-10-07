package java_generic;

public class MoreParameter<T,V> {
	T t;
	V v;
	//两个类型参数
	MoreParameter(T t1, V v1) {
		t = t1;
		v = v1;
	}
	// 显示T和V的类型
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

	//测试
	public static void main(String args[]) {
		// 指定类型参数的实际类型
		MoreParameter<Integer, Double> tv= new MoreParameter<Integer, Double>(100, 12.56);
		tv.printTypes();
		System.out.println("T变量中的值为:" + tv.getT());
		System.out.println("V变量中的值为:" + tv.getV());
	}
}
