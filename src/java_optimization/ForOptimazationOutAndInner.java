package java_optimization;

public class ForOptimazationOutAndInner {
	static long startTime;// ��ʼʱ��
	static long endTime;// ����ʱ��
	static int i;
	static int j;

	public static void main(String[] args) throws InterruptedException {
		// Ƕ��ѭ����ѡ����С�ڴ�Ƕ�ף�
		// ��С�ڴ�
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < Constant.MIN; i++) {
					for (j = 0; j < Constant.MAX; j++) {
					}
				}
				endTime = System.nanoTime();
				System.out.println("��С�ڴ�ѭ����ʱ��" + (endTime - startTime));
			}
		};

		// �����С
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < Constant.MAX; i++) {
					for (j = 0; j < Constant.MIN; j++) {
					}
				}
				endTime = System.nanoTime();
				System.out.println("�����Сѭ����ʱ��" + (endTime - startTime));
			}
		};

		thread1.start();
		thread2.start();
	}
}