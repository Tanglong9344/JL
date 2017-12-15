package java_optimization;

public class ForOptimazationTryCatch {
	static long startTime;// ��ʼʱ��
	static long endTime;// ����ʱ��
	static int i;
	static int j;

	public static void main(String[] args) throws InterruptedException {
		// �쳣����
		// ѭ������try��
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				try {
					for (i = 0; i < Constant.MIN; i++) {
						for (j = 0; j < Constant.MAX; j++) {
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				endTime = System.nanoTime();
				System.out.println("ѭ������try�ں�ʱ��" + (endTime - startTime));
			}
		};

		// ѭ������try��
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < Constant.MAX; i++) {
					for (j = 0; j < Constant.MIN; j++) {
						try {} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				endTime = System.nanoTime();
				System.out.println("ѭ������try���ʱ��" + (endTime - startTime));
			}
		};

		thread1.start();
		thread2.start();
	}
}