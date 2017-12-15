package design_mode;

/**
 * ����ģʽ:ͨ�����ع��췽��ʵ��(����ģʽ)
 * һ�������һ��ʵ��
 * ���ṩһ����������ȫ�ַ��ʵ�
 * �ο�Runtime��
 *
 * ע�⣺Ҫ��ֹ��������ͨ��������Ʒ���˽�й�����<code>SingleInstanceTest</code>
 * �����ʽ��ʹ��ö��ʵ�ֵ���ģʽ<code>SingleInstanceEnum.java</code>
 *
 * ����ģʽʵ��ע�����
 * 1.�̰߳�ȫ
 * 2.�ӳټ���
 * 3.���л��뷴���л���ȫ
 * @author ����
 */
public class SingleInstance {
	//��̬����ʵ������
	private static final SingleInstance INSTANCE = new SingleInstance();
	//����ʵ������
	public static SingleInstance getInstance(){
		return INSTANCE;
	}
	//˽�й��췽��
	private SingleInstance(){
		System.out.println("����ģʽ");
	}
}