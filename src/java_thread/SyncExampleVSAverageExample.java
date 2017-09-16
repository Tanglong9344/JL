package java_thread;

public class SyncExampleVSAverageExample {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("ͬ���̣߳�");
		SyncThread2 st1 = new SyncThread2();
		new Thread(st1, "ͬ���߳�1").start();
		new Thread(st1, "ͬ���߳�2").start();
		// ����SyncThread���ͬ������call()
		System.out.println(st1.Perform());
	}
}

/**
 * ͬ���߳�
 * @author tanglong
 */
class SyncThread2 implements Runnable {
	private static final int DO_TIMES =10;
	private int x = 5;
	private int y = 5;
	// ����SyncThread��ͬ������
	// ��дRunnable�ӿڵ�run()����������synchronized
	@Override
	public void run() {
		for (int i = 0; i <DO_TIMES ; i++) {
			x++;
			y++;
			try {
				Thread.sleep(200); // ��ǰ���е��߳�����200����
			} catch (InterruptedException e) {
				System.out.println("�̳߳�����");
			}
			System.out.println(Thread.currentThread().getName() + " x=" + x + ",y=" + y);
		}
	}

	// �Զ��巽������������synchronized
	public synchronized String Perform() {
		String name = Thread.currentThread().getName();
		return "��ǰ�������е��̣߳� " + name;
	}
}