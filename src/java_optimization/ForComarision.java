package java_optimization;

/**
 * forѭ��
 * @author ����
 */
public class ForComarision {
	static long startTime;// ��ʼʱ��
	static long endTime;// ����ʱ��
	static int i,j;

	public static void main(String[] args) throws InterruptedException {
		// forѭ��
		// ��ͨѭ��
		Thread threadGeneral = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < Constant.MIN; i++) {
					for (j = 0; j < Constant.MAX; j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("��ͨѭ����ʱ��" + (endTime - startTime) + "ns");
			}
		};

		// ��forѭ��
		Thread threadSimple = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i++ < Constant.MAX;) {
					for (j = 0; j++ < Constant.MIN;) {}
				}
				endTime = System.nanoTime();
				System.out.println("��ѭ����ʱ��" + (endTime - startTime) + "ns");
			}
		};
		threadGeneral.start();
		threadSimple.start();
	}
}