package java_thread;

public class ThreadRunnable {
	//This is a test
	public static void main(String[] args) throws InterruptedException {
		SyncThread st1 = new SyncThread();
		new Thread(st1, "ͬ���߳�1").start();
		new Thread(st1, "ͬ���߳�2").start();

		System.out.println("��ǰ���еĽ��̣�"+Thread.currentThread().getName());
	}
}

/**
 * ͬ���߳�
 * @author tanglong
 */
class SyncThread implements Runnable {
	private static final int DO_TIMES =10;//��������
	private int x = 0;
	private int y = 0;
	// ����SyncThread��ͬ������
	// ��дRunnable�ӿڵ�run()����������synchronized
	@Override
	public synchronized void run() {
		for (int i = 0; i<DO_TIMES ; i++) {
			x++;
			y++;
			try {
				Thread.sleep(10);//��ǰ���е��߳�����10����
			} catch (InterruptedException e) {
				System.out.println("�������ߡ�");
			}
			System.out.println(Thread.currentThread().getName() + ",x=" + x + ",y=" + y);
		}
	}
}