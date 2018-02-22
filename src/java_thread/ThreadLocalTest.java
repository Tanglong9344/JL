package java_thread;

/**
 * ThreadLocal test
 *
 * Java中的ThreadLocal类可以让你创建的变量只被同一个线程进行读和写操作。
 * 因此，尽管有两个线程同时执行一段相同的代码，而且这段代码又有一个指向同一个
 * ThreadLocal变量的引用，但是这两个线程依然不能看到彼此的ThreadLocal变量域
 *
 * @author 唐龙
 *
 */
public class ThreadLocalTest {
	public static void main(String[] args) {
		RunnableInstance sharedInstance = new RunnableInstance();
		Thread thread1 = new Thread(sharedInstance);
		Thread thread2 = new Thread(sharedInstance);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static class RunnableInstance implements Runnable{
		private ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
		@Override
		public void run() {
			tl.set((int)(Math.random() * 100));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Local variable in a thread: " + tl.get());
		}
	}
}