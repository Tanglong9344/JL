package java_thread;

public class CurrentThreadTest extends Thread {
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		CurrentThreadTest exit = new CurrentThreadTest();
		// ��ȡ���߳�
		Thread th = Thread.currentThread();
		exit.start();
		System.out.println("���߳̿�ʼ���С�����");
		try {
			System.out.println("���߿�ʼ����");
			th.sleep(1000);// ���߳���ͣ1s
			System.out.println("���߽�������");
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
		System.out.println("���߳����н���");
	}

	@Override
	public void run() {
		System.out.println("�߳����������С�����");
		// ǿ��JVM�˳�
		//System.exit(0);
	}
}