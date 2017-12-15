package java_optimization;

public class ForOptimazationTryCatch {
	static long startTime;// 开始时间
	static long endTime;// 结束时间
	static int i;
	static int j;

	public static void main(String[] args) throws InterruptedException {
		// 异常捕获
		// 循环放在try内
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
				System.out.println("循环放在try内耗时：" + (endTime - startTime));
			}
		};

		// 循环放在try外
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
				System.out.println("循环放在try外耗时：" + (endTime - startTime));
			}
		};

		thread1.start();
		thread2.start();
	}
}