package java_thread;

public class CurrentThreadTest extends Thread {
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		CurrentThreadTest ctt = new CurrentThreadTest();
		// 获取主线程
		Thread cth = Thread.currentThread();
		//System.out.println("ctt="+ctt+",cth="+cth);
		ctt.start();
		System.out.println("主线程开始运行。。。");
		try {
			System.out.println("休眠开始～～");
			cth.sleep(1000);// 令线程暂停1s
			System.out.println("休眠结束～～");
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
		System.out.println("主线程运行结束");
	}

	@Override
	public void run() {
		System.out.println("线程正在运行中。。。");
		// 强制JVM退出
		//System.exit(0);
	}
}