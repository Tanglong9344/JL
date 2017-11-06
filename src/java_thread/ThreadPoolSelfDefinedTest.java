package java_thread;

public class ThreadPoolSelfDefinedTest {
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolSelfDefined pool = new ThreadPoolSelfDefined();
		for (int i = 0; i < 500; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("---执行任务---");
					//任务可能是打印一句话
					//可能是访问文件
					//可能是做排序
				}
			};
			//添加任务的速度慢于消费任务的速度
			pool.add(task);
			Thread.sleep(100);//休眠0.1s
		}
	}
}