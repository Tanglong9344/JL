package design_mode;

/**
 * ����ģʽ:ͨ�����ع��췽��ʵ��(����ģʽ���ӳټ���)
 * ȱ�㣬���̰߳�ȫ
 *
 * @author ����
 */
public class SingleInstanceLazy {
	//��̬����ʵ������
	private static SingleInstanceLazy instance = null;
	//����ʵ������
	public static SingleInstanceLazy getInstance(){
		if(instance == null){
			instance = new SingleInstanceLazy();
		}
		return instance;
	}
	//˽�й��췽��
	private SingleInstanceLazy(){
		System.out.println("����ģʽ");
	}
}