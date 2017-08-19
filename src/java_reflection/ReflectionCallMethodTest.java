package java_reflection;

import java.lang.reflect.Method;

public class ReflectionCallMethodTest {
	public static void main(String[] args) {
		Hero h = new Hero();
		// 使用传统的方式，调用方法
		h.setName("盘古");
		System.out.println("一般调用方法:"+h.getName());
		try {
			// 获取这个类的名字叫做setName，参数类型是String的方法
			Method ms = h.getClass().getMethod("setName", String.class);
			// 对h对象调用方法
			ms.invoke(h, "KungFuBoy");
			Method mg = h.getClass().getMethod("getName");
			System.out.println("反射调用方法:"+mg.invoke(h));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
