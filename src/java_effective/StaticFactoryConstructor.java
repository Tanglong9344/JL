package java_effective;

/**
 * ʹ�þ�̬��������ʵ������
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