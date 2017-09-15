package java_thread;

public class SyncExampleVSAverageExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("同步线程：");
		SyncThread2 st1 = new SyncThread2();
		new Thread(st1, "同步线程1").start();
		new Thread(st1, "同步线程2").start();
		// 调用SyncThread类的同步方法call()
		System.out.println(st1.Perform());
	}
}

/**
 * 同步线程
 * @author tanglong
 */
class SyncThread2 implements Runnable {
	private static final int DO_TIMES =10;
	private int x = 5;
	private int y = 5;
	// 定义SyncThread的同步方法
	// 重写Runnable接口的run()，并声明成synchronized
	@Override
	public void run() {
		for (int i = 0; i <DO_TIMES ; i++) {
			x++;
			y++;
			try {
				Thread.sleep(200); // 当前运行的线程休眠200毫秒
			} catch (InterruptedException e) {
				System.out.println("线程出错了");
			}
			System.out.println(Thread.currentThread().getName() + " x=" + x + ",y=" + y);
		}
	}

	// 自定义方法，并声明成synchronized
	public synchronized String Perform() {
		String name = Thread.currentThread().getName();
		return "当前正在运行的线程： " + name;
	}
}