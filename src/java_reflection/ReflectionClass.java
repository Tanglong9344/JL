package java_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ͨ�����������
 * @author ����
 */
public class ReflectionClass {
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{
		//ͨ�����������
		//��1
		Class<?> c1 = Class.forName("java_reflection.Hero");
		testMethod(c1);
		//��2
		Class<Hero> c2 = Hero.class;
		testMethod(c2);
		//��3
		Class<? extends Hero> c3 = new Hero("����").getClass();
		testMethod(c3);
	}

	public static void testMethod(Class<?> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{
		System.out.println("class:" + clazz);
		//ͨ�������ȡtoString����
		Method m = clazz.getMethod("toString");
		System.out.println("����toString:" + m);
		System.out.println("���÷���toString:" + m.invoke(clazz.getConstructor(String.class).newInstance("����"))+"\n");
	}
}