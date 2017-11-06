package java_thread;

public class ThreadDeadLock {
	//This is a test
	public static void main(String[] args) {
		DeadLockThread dlt = new DeadLockThread();
		dlt.t1.start();
		dlt.t2.start();
	}
}

/**死锁类*/
class DeadLockThread extends Thread{
	private String s1="AA";
	private String s2="BB";
	//线程t1
	Thread t1 = new Thread(){
		@Override
		public void run(){
			synchronized (s1) {
				System.out.println("t1已占有"+s1);
				try {
					Thread.sleep(1000);//停顿1000秒，另一个线程有足够的时间占有其它资源
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t1 试图占有"+s2);
				System.out.println("t1 等待中 。。。。");
				synchronized (s2) {
					System.out.println("do something");
				}
			}

		}
	};
	//线程t2
	Thread t2 = new Thread(){
		@Override
		public void run(){
			synchronized (s2) {
				System.out.println("t2 已占有"+s2);
				try {
					Thread.sleep(1000);//停顿1000秒，另一个线程有足够的时间占有其它资源
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t2 试图占有"+s1);
				System.out.println("t2 等待中 。。。。");
				synchronized (s1) {
					System.out.println("do something");
				}
			}
		}
	};
}