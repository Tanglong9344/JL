package java_thread;

public class ThreadDeadLock {
	//This is a test
	public static void main(String[] args) {
		DeadLockThread dlt = new DeadLockThread();
		dlt.t1.start();
		dlt.t2.start();
	}
}

/**������*/
class DeadLockThread extends Thread{
	private String s1="AA";
	private String s2="BB";
	//�߳�t1
	Thread t1 = new Thread(){
		@Override
		public void run(){
			synchronized (s1) {
				System.out.println("t1��ռ��"+s1);
				try {
					Thread.sleep(1000);//ͣ��1000�룬��һ���߳����㹻��ʱ��ռ��������Դ
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t1 ��ͼռ��"+s2);
				System.out.println("t1 �ȴ��� ��������");
				synchronized (s2) {
					System.out.println("do something");
				}
			}

		}
	};
	//�߳�t2
	Thread t2 = new Thread(){
		@Override
		public void run(){
			synchronized (s2) {
				System.out.println("t2 ��ռ��"+s2);
				try {
					Thread.sleep(1000);//ͣ��1000�룬��һ���߳����㹻��ʱ��ռ��������Դ
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t2 ��ͼռ��"+s1);
				System.out.println("t2 �ȴ��� ��������");
				synchronized (s1) {
					System.out.println("do something");
				}
			}
		}
	};
}