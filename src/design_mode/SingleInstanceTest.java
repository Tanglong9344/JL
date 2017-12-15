package design_mode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ����ģʽ����
 * @author ����
 */
public class SingleInstanceTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/**��̬ʵ��*/
		SingleInstance ste1 = SingleInstance.getInstance();

		/**��ȫ����*/
		// �����ȡ������
		Constructor<SingleInstance> cls = SingleInstance.class.getDeclaredConstructor();
		// ��Ϊ�ɼ�
		cls.setAccessible(true);
		//ʵ����
		SingleInstance ste2 = cls.newInstance();

		//����ж�
		System.out.println(ste1.equals(ste2));

		/**enumʵ��*/
		SingleInstanceEnum.getInstance();
		/**��ȫ����*/
		// �����ȡ������
		Constructor<SingleInstanceEnum> clsEnum = SingleInstanceEnum.class.getDeclaredConstructor();
		// ��Ϊ�ɼ�
		clsEnum.setAccessible(true);
		//ʵ��������ֹʵ����
		//clsEnum.newInstance();
	}
}