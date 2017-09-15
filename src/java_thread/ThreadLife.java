package java_thread;

import java.util.Date;

public class ThreadLife {
	public void startY() {
		ThreadY ty = new ThreadY();
		ty.startThreadY(); // 启动ThreadY线程
		try {
			Thread.sleep(1000); // 当前线程休眠一秒钟
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ty.stopThreadY(); // 停止ThreadY线程
	}

	public void startX() { // 开始第二个
		Runnable runnX = new ThreadX(); // 创建实例
		Thread threadX = new Thread(runnX); // 将实例放入线程中
		threadX.start(); // start方法启动线程
	}

	public static void main(String[] args) { // java程序主入口处
		ThreadLife test = new ThreadLife(); // 实例化对象
		test.startY(); // 调用方法
		test.startX();
	}

}

/**
 * 继承java.lang.Thread类定义线程
 * @author 唐龙
 */
class ThreadY extends Thread {
	private boolean isRunState = false; // 标记线程是否需要运行
	@Override
	public void start() {
		this.isRunState = true; // 将isRunState置为ture，表示线程需要运行
		super.start();
	}
	@Override
	public void run() {
		int i = 0;
		try {
			// 如果isRunState为真，说明线程还可以继续运行
			while (isRunState) {
				this.setName("Thread-" + i++);
				System.out.println("线程Y：" + this.getName() + " 正在运行");
				Thread.sleep(200); // sleep方法将当前线程休眠。
			}
		} catch (Exception e) {
		}
		System.out.println(this.getName() + "运行结束...");
	}

	public void setRunning(boolean isRunState) {
		this.isRunState = isRunState;
	}

	// 启动ThreadY线程
	public void startThreadY() {
		System.out.println("启动线程Y...");
		this.start();
	}

	// 停止ThreadY线程
	public void stopThreadY() {
		System.out.println("结束线程Y...");
		this.setRunning(false);
	}
}

/**
 * 实现java.lang.Runnable接口定义线程
 * @author 唐龙
 */
class ThreadX implements Runnable {
	private Date runDate; // 线程被运行的时刻
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		System.out.println("线程X已经启动...");
		this.runDate = new Date();
		System.out.println("启动时间:" + runDate.toLocaleString());
	}
}