package java_optimization;

/**
 * 方法调用放在循环之外
 * @author 唐龙
 */
public class ForOptimazationCallMethod {
	static long startTime;// 开始时间
	static long endTime;// 结束时间
	static int i,j;

	public static void main(String[] args) throws InterruptedException {
		// 方法调用
		/**外部调用*/
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				int MIN = getMIN();
				int MAX = getMAX();
				startTime = System.nanoTime();
				for (i = 0; i < MIN;i++) {
					for (j = 0; j < MAX;j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("在循环外部调用方法耗时：" + (endTime - startTime) + "ns");
			}
		};

		/**内部调用*/
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < getMIN();i++) {
					for (j = 0; j < getMAX();j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("在循环内部调用方法耗时：" + (endTime - startTime) + "ns");
			}
		};
		thread1.start();
		thread2.start();
	}

	public static int getMIN() {
		for (int i = 0; i < Constant.MAX;i++) {
			;
		}
		return Constant.MIN;
	}

	public static int getMAX() {
		for (int i = 0; i < Constant.MAX;i++) {
			;
		}
		return Constant.MAX;
	}
}