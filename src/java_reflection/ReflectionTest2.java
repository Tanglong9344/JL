package java_reflection;

import java.lang.reflect.Constructor;

public class ReflectionTest2 {
	public static void main(String[] args) {
		// ��ͳ��ʹ��new�ķ�ʽ��������
		System.out.println("��ͳ��ʹ��new�ķ�ʽ��������:");
		Hero h1 = new Hero();
		h1.name = "teemo";
		System.out.println(h1);
		try {
			// ʹ�÷���ķ�ʽ��������
			System.out.println("ʹ�÷���ķ�ʽ��������:");
			String className = "java_reflection.Hero";
			// �����
			Class<?> pClass = Class.forName(className);
			// ������
			Constructor<?> c = pClass.getConstructor();
			// ͨ��������ʵ����
			Hero h2 = (Hero) c.newInstance();
			System.out.println("test1:" + h2);
			System.out.println("test2:" + Class.forName("java_reflection.Hero").newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
