package java_reflection;

import java.lang.reflect.Method;

/**
 * ͨ��������÷���
 * @author ����
 */
public class ReflectionInvoke {
	public static void main(String[] args) {
		Hero h = new Hero("����");
		//һ����÷���
		h.setName("���Ƴ�");
		System.out.println("һ����÷�����" + h.getName());
		try {
			// ��ȡ���������ֽ���setName������������String�ķ���
			Method ms = h.getClass().getMethod("setName", String.class);
			//��h������÷���
			ms.invoke(h,"�ش�");
			ms = h.getClass().getMethod("getName");
			System.out.println("���÷�����÷�����" + ms.invoke(h));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}