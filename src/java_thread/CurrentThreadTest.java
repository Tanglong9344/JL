package java_thread;

public class CurrentThreadTest extends Thread {
	public static void main(String args[]) {
		CurrentThreadTest ctt = new CurrentThreadTest();
		ctt.start();
		System.out.println("���߳̿�ʼ����..., Id: " + ctt.getId());
		try {
			System.out.println("���߿�ʼ����");
			Thread.sleep(1000);// ���߳���ͣ1s
			System.out.println("���߽�������");
		} catch (InterruptedException el) {
			el.printStackTrace();
		}
		System.out.println("���߳����н���...");
	}

	@Override
	public void run() {
		System.out.println("�߳�����������..., Id: " + this.getId());
		// ǿ��JVM�˳�
		// System.exit(0);
	}
}