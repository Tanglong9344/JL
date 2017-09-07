package java_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
	public static void main(String[] args)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		// 通过反射加载类
		String className = "java_reflection.Hero";
		Class<?> pClass1 = Class.forName(className);
		Class<Hero> pClass2 = Hero.class;
		Class<? extends Hero> pClass3 = new Hero().getClass();

		System.out.println("Class.forName(className):" + pClass1);
		System.out.println("Hero.class:" + pClass2);
		System.out.println("new Hero().getClass():" + pClass3);

		// 通过反射调用方法
		String mtdName = "toString";
		Method m = pClass1.getMethod(mtdName);
		System.out.println("方法:" + m);
		System.out.println("方法调用:" + m.invoke(pClass1.newInstance()));
	}
}