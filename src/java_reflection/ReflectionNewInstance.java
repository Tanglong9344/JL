package java_reflection;

import java.lang.reflect.Constructor;

/**
 * 通过反射实例化类
 * @author 唐龙
 */
public class ReflectionNewInstance {
	public static void main(String[] args) {
		//传统的使用new的方式创建对象
		System.out.println(new Hero("关羽"));
		try {
			//使用反射的方式创建对象
			Class<?> clazz = Class.forName("java_reflection.Hero");
			//获取带参构造方法
			Constructor<?> c1 = clazz.getConstructor(String.class);
			//通过带参构造方法实例化
			System.out.println("test1:" + c1.newInstance("关羽"));

			//获取无参构造方法
			//类中必须要有无参构造方法
			Constructor<?> c2 = clazz.getConstructor();
			//通过无参构造方法实例化
			System.out.println("test2:" + c2.newInstance());
			//也可以直接使用Class.forName("java_reflection.Hero").newInstance()
			//默认调用无参构造方法
			System.out.println("test3:"+Class.forName("java_reflection.Hero").newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}