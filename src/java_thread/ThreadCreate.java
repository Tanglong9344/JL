package java_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadCreate {
	//This is a test
	public static void main(String[] args) throws InterruptedException {
		//ThreadX
		Thread tx = new Thread(new ThreadX());
		tx.start();

		//ThreadY
		ThreadY ty = new ThreadY();
		ty.startThreadY();
		Thread.sleep(1000);
		ty.stopThreadY();

	}
}

/**
 * 实现java.lang.Runnable接口定义线程
 *
 * @author 唐龙
 */
class ThreadX implements Runnable {
	@Override
	public void run() {
		System.out.println("线程X已经启动...");
		System.out.println("启动时间:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}
}

/** 继承java.lang.Thread类定义线程 */
class ThreadY extends Thread {
	private boolean isRunState = false;//标记线程是否需要运行
	@Override
	public void start() {
		this.isRunState = true;//将isRunStateState置为ture，表示线程需要运行
		super.start();
	}
	@Override
	public void run() {
		int i = 0;
		try {
			while (isRunState) {
				this.setName("Thread-" + (++i));
				System.out.println("线程Y：" + this.getName() + " 正在运行");
				Thread.sleep(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + "运行结束...");
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

	public void setRunning(boolean isRunStateState) {
		this.isRunState = isRunStateState;
	}
}