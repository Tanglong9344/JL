package java_reflection;

import java.lang.reflect.Constructor;

/**
 * ͨ������ʵ������
 * @author ����
 */
public class ReflectionNewInstance {
	public static void main(String[] args) {
		//��ͳ��ʹ��new�ķ�ʽ��������
		System.out.println(new Hero("����"));
		try {
			//ʹ�÷���ķ�ʽ��������
			Class<?> clazz = Class.forName("java_reflection.Hero");
			//��ȡ���ι��췽��
			Constructor<?> c1 = clazz.getConstructor(String.class);
			//ͨ�����ι��췽��ʵ����
			System.out.println("test1:" + c1.newInstance("����"));

			//��ȡ�޲ι��췽��
			//���б���Ҫ���޲ι��췽��
			Constructor<?> c2 = clazz.getConstructor();
			//ͨ���޲ι��췽��ʵ����
			System.out.println("test2:" + c2.newInstance());
			//Ҳ����ֱ��ʹ��Class.forName("java_reflection.Hero").newInstance()
			//Ĭ�ϵ����޲ι��췽��
			System.out.println("test3:"+Class.forName("java_reflection.Hero").newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}