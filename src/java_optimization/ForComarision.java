package java_optimization;

/**
 * for循环
 * @author 唐龙
 */
public class ForComarision {
	static long startTime;// 开始时间
	static long endTime;// 结束时间
	static int i,j;

	public static void main(String[] args) throws InterruptedException {
		// for循环
		// 普通循环
		Thread threadGeneral = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < CommonConstants.MIN; i++) {
					for (j = 0; j < CommonConstants.MAX; j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("普通循环耗时：" + (endTime - startTime) + "ns");
			}
		};

		// 简单for循环
		Thread threadSimple = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i++ < CommonConstants.MAX;) {
					for (j = 0; j++ < CommonConstants.MIN;) {}
				}
				endTime = System.nanoTime();
				System.out.println("简单循环耗时：" + (endTime - startTime) + "ns");
			}
		};
		threadGeneral.start();
		threadSimple.start();
	}
}