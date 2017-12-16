package java_optimization;

/**
 * ��ȡ��ѭ���޹صı��ʽ��ѭ��֮��
 * @author ����
 */
public class ForOptimazationGetUnconcernExpOut {
	static long startTime;// ��ʼʱ��
	static long endTime;// ����ʱ��
	static int i,j;

	public static void main(String[] args) throws InterruptedException {
		// ��ȡ��ѭ���޹صı��ʽ
		// δ��ȡ
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				@SuppressWarnings("unused")
				int r = 0;
				startTime = System.nanoTime();
				for (i = 0; i < Constant.MIN; i++) {
					for (j = 0; j < Constant.MAX; j++) {
						r *= i * j * Constant.MIN * Constant.MAX;
					}
				}
				endTime = System.nanoTime();
				System.out.println("δ��ȡ��ѭ���޹صı��ʽ��ʱ��" + (endTime - startTime) + "ns");
			}
		};

		// ��ȡ
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				int m = Constant.MIN * Constant.MAX;
				@SuppressWarnings("unused")
				int r = 0;
				startTime = System.nanoTime();
				for (i = 0; i < Constant.MIN; i++) {
					for (j = 0; j < Constant.MAX; j++) {
						r = i * j * m;
					}
				}
				endTime = System.nanoTime();
				System.out.println("��ȡ��ѭ���޹صı��ʽ   ��ʱ��" + (endTime - startTime) + "ns");
			}
		};
		thread1.start();
		thread2.start();
	}
}