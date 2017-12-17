package java_optimization;

/**
 * 再循环之外初始化循环变量
 * @author 唐龙
 */
public class ForOptimazationInit {
	static long startTime;// 开始时间
	static long endTime;// 结束时间

	public static void main(String[] args) throws InterruptedException {
		// 循环变量初始化
		// 初始化再循环外
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				int i, j;
				for (i = 0; i < CommonConstants.MIN; i++) {
					for (j = 0; j < CommonConstants.MAX; j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("初始化在循环外耗时：" + (endTime - startTime) + "ns");
			}
		};

		// 初始化再循环内
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (int i = 0; i < CommonConstants.MIN; i++) {
					for (int j = 0; j < CommonConstants.MAX; j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("初始化在循环内耗时：" + (endTime - startTime) + "ns");
			}
		};
		thread1.start();
		thread2.start();
	}
}