package java_optimization;

/**
 * 提取与循环无关的表达式到循环之外
 * @author 唐龙
 */
public class ForOptimazationGetUnconcernExpOut {
	static long startTime;// 开始时间
	static long endTime;// 结束时间
	static int i,j;

	public static void main(String[] args) throws InterruptedException {
		// 提取与循环无关的表达式
		// 未提取
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
				System.out.println("未提取与循环无关的表达式耗时：" + (endTime - startTime) + "ns");
			}
		};

		// 提取
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
				System.out.println("提取与循环无关的表达式   耗时：" + (endTime - startTime) + "ns");
			}
		};
		thread1.start();
		thread2.start();
	}
}