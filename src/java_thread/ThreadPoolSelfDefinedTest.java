package java_thread;

public class ThreadPoolSelfDefinedTest {
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolSelfDefined pool = new ThreadPoolSelfDefined();
		for (int i = 0; i < 500; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("---ִ������---");
					//��������Ǵ�ӡһ�仰
					//�����Ƿ����ļ�
					//������������
				}
			};
			//���������ٶ���������������ٶ�
			pool.add(task);
			Thread.sleep(100);//����0.1s
		}
	}
}