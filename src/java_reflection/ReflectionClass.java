package java_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射加载类
 * @author 唐龙
 */
public class ReflectionClass {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{
		//通过反射加载类
		//例1
		Class<?> c1 = Class.forName("java_reflection.Hero");
		testMethod(c1);
		//例2
		Class<Hero> c2 = Hero.class;
		testMethod(c2);
		//例3
		Class<? extends Hero> c3 = new Hero("关羽").getClass();
		testMethod(c3);
	}

	public static void testMethod(Class<?> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{
		System.out.println("class:" + clazz);
		//通过反射获取toString方法
		Method m = clazz.getMethod("toString");
		System.out.println("方法toString:" + m);
		System.out.println("调用方法toString:" + m.invoke(clazz.getConstructor(String.class).newInstance("唐龙"))+"\n");
	}
}