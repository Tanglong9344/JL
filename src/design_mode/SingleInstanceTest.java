package design_mode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ����ģʽ����
 * @author ����
 */
public class SingleInstanceTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingleInstance ste1 = SingleInstance.getInstance();

		/**��ȫ����*/
		// �����ȡ������
		Constructor<SingleInstance> cls = SingleInstance.class.getDeclaredConstructor();
		// ��Ϊ�ɼ�
		cls.setAccessible(true);
		//ʵ����
		SingleInstance ste2 = cls.newInstance();

		System.out.println("---------�ȽϿ�ʼ-----------");
		//����ж�
		System.out.println(ste1.equals(ste2));
	}
}