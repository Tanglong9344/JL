package java_thread;

public class CurrentThreadTest extends Thread {
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		CurrentThreadTest ctt = new CurrentThreadTest();
		// ��ȡ���߳�
		Thread cth = Thread.currentThread();
		//System.out.println("ctt="+ctt+",cth="+cth);
		ctt.start();
		System.out.println("���߳̿�ʼ���С�����");
		try {
			System.out.println("���߿�ʼ����");
			cth.sleep(1000);// ���߳���ͣ1s
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