package java_reflection;

import java.lang.reflect.Method;

public class ReflectionCallMethodTest {
	public static void main(String[] args) {
		Hero h = new Hero();
		// ʹ�ô�ͳ�ķ�ʽ�����÷���
		h.setName("�̹�");
		System.out.println("һ����÷���:"+h.getName());
		try {
			// ��ȡ���������ֽ���setName������������String�ķ���
			Method ms = h.getClass().getMethod("setName", String.class);
			// ��h������÷���
			ms.invoke(h, "KungFuBoy");
			Method mg = h.getClass().getMethod("getName");
			System.out.println("������÷���:"+mg.invoke(h));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
