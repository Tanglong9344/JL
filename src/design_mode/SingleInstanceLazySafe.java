package design_mode;

/**
 * ����ģʽ:ͨ�����ع��췽��ʵ��(����ģʽ���ӳټ���+�̰߳�ȫ)
 * 1.ʹ�� volatile
 * 2.ʹ��synchronized�ؼ���ʵ��ͬ������
 * 3.˫��null����������+ͬ������
 *
 * ��volatile���εı���
 * 1. ÿ�α��̷߳���ʱ����ǿ�ȴӹ����ڴ����ض��ñ�����ֵ��
 * 2. �����������仯ʱ��ǿ���߳̽��仯ֵ��д�������ڴ档
 * 3. volatile���ε���VM�б�Ҫ�Ĵ����Ż���������Ч���ϱȽϵͣ����һ���ڱ�Ҫʱ��ʹ�ô˹ؼ��֡�
 *
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