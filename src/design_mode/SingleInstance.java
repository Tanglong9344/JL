package design_mode;

/**
 * ����ģʽ:ͨ�����ع��췽��ʵ��
 * һ�������һ��ʵ��
 * ���ṩһ����������ȫ�ַ��ʵ�
 * ע�⣺Ҫ��ֹ��������ͨ��������Ʒ���˽�й�����<code>SingleInstanceTest</code>
 * �ο�Runtime��
 *
 * @author ����
 */
public class SingleInstance {
	//��̬����ʵ������
	private static final SingleInstance singleInstance = new SingleInstance();
	//����ʵ������
	public static SingleInstance getSingleInstance(){
		return singleInstance;
	}
	//˽�й��췽��
	private SingleInstance(){
		System.out.println("����ģʽ");
	}
}