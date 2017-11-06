package java_thread;

public class ThreadSychronizedParameter {
	//This is a test
	public static void main(String[] args) {
		DoorKey1 one = new DoorKey1();
		DoorKey2 two = new DoorKey2();
		GoWrong daemon = new GoWrong();
		one.start();//启动线程
		two.start();
		daemon.start();
	}

	static String[] keys = new String[] {"第1把钥匙", "第2把钥匙"};

	/**两个人开门都需要两把钥匙，使用synchronized实现同步操作*/
	static class DoorKey1 extends Thread {
		@Override
		public void run() {
			// 在同一时间只能有一个进程访问
			synchronized (keys[0]) {
				System.out.println("我拿起了" + keys[0] + ",在等着朋友用" + keys[1] + "开防盗门");
				try {
					Thread.sleep(3000);//线程休眠3s
				} catch (Exception e) {
					System.out.println("线程休眠出错：" + e.getMessage());
				}
				synchronized (keys[1]) {
					System.out.println("我又拿出来" + keys[1] + "打开了防盗门");
				}
			}
		}
	}

	/**两个人开门都需要两把钥匙，使用synchronized实现同步操作*/
	static class DoorKey2 extends Thread {
		@Override
		public void run() {
			synchronized (keys[0]) {
				System.out.println("\n朋友拿出了" + keys[0] + ",在等待我用" + keys[1] + "开防盗门");
				try {
					Thread.sleep(3000);//线程休眠3s
				} catch (Exception e) {
					System.out.println("线程休眠出错：" + e.getMessage());
				}
				synchronized (keys[1]) {
					System.out.println("朋友又拿出了" + keys[1] + "打开了防盗门");
				}
			}
		}
	}

	/**静态守护线程类（守护进程是为其他进程提供服务的进程，例如GC进程）*/
	static class GoWrong extends Thread {
		public GoWrong() {
			this.setDaemon(true);//设置为线程守护
		}
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);//线程休眠
				} catch (Exception e) {
					System.out.println("线程休眠出错：" + e.getMessage());
				}
				System.out.println("守护线程：程序正在运行...");
			}
		}
	}
}