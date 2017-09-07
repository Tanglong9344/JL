package java_optimization;

public class ForOptimazationOutAndInner {
	static long startTime;// 开始时间
	static long endTime;// 结束时间
	static int i;
	static int j;

	public static void main(String[] args) throws InterruptedException {
		// 嵌套循环（选择外小内大嵌套）
		// 外小内大
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < Constant.MIN; i++) {
					for (j = 0; j < Constant.MAX; j++) {
					}
				}
				endTime = System.nanoTime();
				System.out.println("外小内大循环耗时：" + (endTime - startTime));
			}
		};

		// 外大内小
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < Constant.MAX; i++) {
					for (j = 0; j < Constant.MIN; j++) {
					}
				}
				endTime = System.nanoTime();
				System.out.println("外大内小循环耗时：" + (endTime - startTime));
			}
		};

		thread1.start();
		thread2.start();
	}
}