package java_optimization;

public class ForOptimazationInit {
	static long startTime;// ��ʼʱ��
	static long endTime;// ����ʱ��

	public static void main(String[] args) throws InterruptedException {
		// ѭ��������ʼ����ѡ���ʼ����ѭ���⣩
		// ��ʼ����ѭ����
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				int i, j;
				for (i = 0; i < Constant.MIN; i++) {
					for (j = 0; j < Constant.MAX; j++) {
					}
				}
				endTime = System.nanoTime();
				System.out.println("��ʼ����ѭ�����ʱ��" + (endTime - startTime));
			}
		};

		// ��ʼ����ѭ����
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (int i = 0; i < Constant.MIN; i++) {
					for (int j = 0; j < Constant.MAX; j++) {
					}
				}
				endTime = System.nanoTime();
				System.out.println("��ʼ����ѭ���ں�ʱ��" + (endTime - startTime));
			}
		};

		thread1.start();
		thread2.start();
	}
}