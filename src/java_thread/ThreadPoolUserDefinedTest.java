package java_thread;

public class ThreadPoolUserDefinedTest {
	public static void main(String[] args) {
		ThreadPoolUserDefined pool = new ThreadPoolUserDefined();
		for (int i = 0; i < 5; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("	---ִ������---");
					//��������Ǵ�ӡһ�仰
					//�����Ƿ����ļ�
					//������������
				}
			};
			//���������ٶ���������������ٶ�
			pool.add(task);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
