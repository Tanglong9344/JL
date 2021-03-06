package java_thread;

import java.util.LinkedList;

/**
 * 自定义线程池
 *
 * @author 唐龙
 *
 */
public class ThreadPoolSelfDefined {
	// 线程池大小
	final int THREAD_POOL_SIZE;
	// 任务容器--元素无需有序
	LinkedList<Runnable> tasks = new LinkedList<Runnable>();
	//试图消费任务的线程
	public ThreadPoolSelfDefined() {
		THREAD_POOL_SIZE = 3;
		// 启动'THREAD_POOL_SIZE个'消费者线程
		synchronized (tasks) {
			for (int i = 0; i < THREAD_POOL_SIZE; i++) {
				new TaskConsumeThread("任务消费者线程  " + i).start();
			}
		}
	}

	//生产者线程
	public void add(Runnable r) {
		synchronized (tasks) {
			tasks.add(r);
			// 唤醒等待的任务消费者线程
			tasks.notifyAll();
		}
	}

	/** 消费者线程 */
	class TaskConsumeThread extends Thread {
		public TaskConsumeThread(String name) {
			super(name);
		}
		Runnable task;
		@Override
		public void run() {
			System.out.println("启动： " + this.getName());
			while (true) {
				synchronized (tasks) {
					while (tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = tasks.removeLast();
					// 允许添加任务的线程可以继续添加任务
					tasks.notifyAll();
				}
				System.out.print(this.getName() + " 获取到任务，并执行：");
				task.run();
			}
		}
	}
}