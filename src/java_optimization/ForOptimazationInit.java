package java_optimization;

/**
 * ��ѭ��֮���ʼ��ѭ������
 * @author ����
 */
public class ForOptimazationInit {
	static long startTime;// ��ʼʱ��
	static long endTime;// ����ʱ��

	public static void main(String[] args) throws InterruptedException {
		// ѭ��������ʼ��
		// ��ʼ����ѭ����
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				int i, j;
				for (i = 0; i < CommonConstants.MIN; i++) {
					for (j = 0; j < CommonConstants.MAX; j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("��ʼ����ѭ�����ʱ��" + (endTime - startTime) + "ns");
			}
		};

		// ��ʼ����ѭ����
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (int i = 0; i < CommonConstants.MIN; i++) {
					for (int j = 0; j < CommonConstants.MAX; j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("��ʼ����ѭ���ں�ʱ��" + (endTime - startTime) + "ns");
			}
		};
		thread1.start();
		thread2.start();
	}
}