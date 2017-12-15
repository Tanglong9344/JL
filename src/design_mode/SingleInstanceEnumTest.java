package design_mode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ����ģʽ��ʹ��ö��ʵ�ֲ���
 * @author ����
 */
public class SingleInstanceEnumTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingleInstanceEnum ste1 = SingleInstanceEnum.getInstance();

		/**��ȫ����*/
		// �����ȡ������
		Constructor<SingleInstanceEnum> cls = SingleInstanceEnum.class.getDeclaredConstructor();
		// ��Ϊ�ɼ�
		cls.setAccessible(true);
		//ʵ����
		SingleInstanceEnum ste2 = cls.newInstance();

		System.out.println("---------�ȽϿ�ʼ-----------");
		//����ж�
		System.out.println(ste1.equals(ste2));
	}
}