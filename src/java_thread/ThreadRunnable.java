package java_thread;

public class ThreadRunnable {
	//This is a test
	public static void main(String[] args) throws InterruptedException {
		SyncThread st1 = new SyncThread();
		new Thread(st1, "同步线程1").start();
		new Thread(st1, "同步线程2").start();

		System.out.println("当前运行的进程："+Thread.currentThread().getName());
	}
}

/**
 * 同步线程
 * @author tanglong
 */
class SyncThread implements Runnable {
	private static final int DO_TIMES =10;//操作次数
	private int x = 0;
	private int y = 0;
	// 定义SyncThread的同步方法
	// 重写Runnable接口的run()，并声明成synchronized
	@Override
	public synchronized void run() {
		for (int i = 0; i<DO_TIMES ; i++) {
			x++;
			y++;
			try {
				Thread.sleep(10);//当前运行的线程休眠10毫秒
			} catch (InterruptedException e) {
				System.out.println("打破休眠。");
			}
			System.out.println(Thread.currentThread().getName() + ",x=" + x + ",y=" + y);
		}
	}
}