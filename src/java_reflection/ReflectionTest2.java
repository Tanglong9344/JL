package java_reflection;

import java.lang.reflect.Constructor;

public class ReflectionTest2 {
	public static void main(String[] args) {
		// 传统的使用new的方式创建对象
		System.out.println("传统的使用new的方式创建对象:");
		Hero h1 = new Hero();
		h1.name = "teemo";
		System.out.println(h1);
		try {
			// 使用反射的方式创建对象
			System.out.println("使用反射的方式创建对象:");
			String className = "java_reflection.Hero";
			// 类对象
			Class<?> pClass = Class.forName(className);
			// 构造器
			Constructor<?> c = pClass.getConstructor();
			// 通过构造器实例化
			Hero h2 = (Hero) c.newInstance();
			System.out.println("test1:" + h2);
			System.out.println("test2:" + Class.forName("java_reflection.Hero").newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
