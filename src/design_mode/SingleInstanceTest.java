package design_mode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ����ģʽ��ȫ����
 * @author ����
 */
public class SingleInstanceTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//SingleInstance.getSingleInstance();
		//�����ȡ������
		Constructor<SingleInstance> cls = SingleInstance.class.getDeclaredConstructor();
		//��Ϊ�ɼ�
		cls.setAccessible(true);
		//ʵ����
		cls.newInstance();
	}
}