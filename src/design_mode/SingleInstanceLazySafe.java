package design_mode;

/**
 * ����ģʽ:ͨ�����ع��췽��ʵ��(����ģʽ���ӳټ���+�̰߳�ȫ)
 * 1.ʹ�� volatile �ؼ���ʵ��1)�ɼ��Ժ�2)��ָֹ���������Ż�
 * 2.ʹ��synchronized�ؼ���ʵ��ͬ������
 * 3.˫��null����������+ͬ������
 * @author ����
 */
public class SingleInstanceLazySafe {
	//��̬����ʵ������
	private static volatile SingleInstanceLazySafe instance = null;
	//����ʵ������
	public static SingleInstanceLazySafe getInstance(){
		if(instance == null){
			synchronized(SingleInstanceLazySafe.class){
				if(instance == null){
					instance = new SingleInstanceLazySafe();
				}
			}
		}
		return instance;
	}
	//˽�й��췽��
	private SingleInstanceLazySafe(){
		System.out.println("����ģʽ");
	}
}