package java_optimization;

public class ForOptimazationInit {
	static long startTime;// 开始时间
	static long endTime;// 结束时间

	public static void main(String[] args) throws InterruptedException {
		// 循环变量初始化（选择初始化再循环外）
		// 初始化再循环外
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
				System.out.println("初始化在循环外耗时：" + (endTime - startTime));
			}
		};

		// 初始化再循环内
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (int i = 0; i < Constant.MIN; i++) {
					for (int j = 0; j < Constant.MAX; j++) {
					}
				}
				endTime = System.nanoTime();
				System.out.println("初始化在循环内耗时：" + (endTime - startTime));
			}
		};

		thread1.start();
		thread2.start();
	}
}