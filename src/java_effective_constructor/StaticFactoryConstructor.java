package java_effective_constructor;

/**
 * ʹ�þ�̬��������ʵ������
 *
 * �ŵ�
 * 1.������������
 * 2.���Է�������������
 * 3.ʹ��ʵ�����Ĵ�����Ӽ��
 * @author ����
 */
public class StaticFactoryConstructor {
	/**˽�й�����*/
	private StaticFactoryConstructor(){
		System.out.println("Welcome to Static Factory Constructor...");
	}

	/**��̬ʵ��������*/
	public static StaticFactoryConstructor newInstance(){
		return new StaticFactoryConstructor();
	}

	/**��������*/
	public void bye(){
		System.out.println("See you again...");
	}
}