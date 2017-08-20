package java_thread;

public class ThreadPoolUserDefinedTest {
	public static void main(String[] args) {
		ThreadPoolUserDefined pool = new ThreadPoolUserDefined();
		for (int i = 0; i < 5; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("	---执行任务---");
					//任务可能是打印一句话
					//可能是访问文件
					//可能是做排序
				}
			};
			//添加任务的速度慢于消费任务的速度
			pool.add(task);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
