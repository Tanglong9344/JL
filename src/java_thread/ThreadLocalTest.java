package java_thread;

/**
 * ThreadLocal test
 *
 * Java�е�ThreadLocal��������㴴���ı���ֻ��ͬһ���߳̽��ж���д������
 * ��ˣ������������߳�ͬʱִ��һ����ͬ�Ĵ��룬������δ�������һ��ָ��ͬһ��
 * ThreadLocal���������ã������������߳���Ȼ���ܿ����˴˵�ThreadLocal������
 *
 * @author ����
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