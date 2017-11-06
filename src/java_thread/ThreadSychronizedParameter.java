package java_thread;

public class ThreadSychronizedParameter {
	//This is a test
	public static void main(String[] args) {
		DoorKey1 one = new DoorKey1();
		DoorKey2 two = new DoorKey2();
		GoWrong daemon = new GoWrong();
		one.start();//�����߳�
		two.start();
		daemon.start();
	}

	static String[] keys = new String[] {"��1��Կ��", "��2��Կ��"};

	/**�����˿��Ŷ���Ҫ����Կ�ף�ʹ��synchronizedʵ��ͬ������*/
	static class DoorKey1 extends Thread {
		@Override
		public void run() {
			// ��ͬһʱ��ֻ����һ�����̷���
			synchronized (keys[0]) {
				System.out.println("��������" + keys[0] + ",�ڵ���������" + keys[1] + "��������");
				try {
					Thread.sleep(3000);//�߳�����3s
				} catch (Exception e) {
					System.out.println("�߳����߳���" + e.getMessage());
				}
				synchronized (keys[1]) {
					System.out.println("�����ó���" + keys[1] + "���˷�����");
				}
			}
		}
	}

	/**�����˿��Ŷ���Ҫ����Կ�ף�ʹ��synchronizedʵ��ͬ������*/
	static class DoorKey2 extends Thread {
		@Override
		public void run() {
			synchronized (keys[0]) {
				System.out.println("\n�����ó���" + keys[0] + ",�ڵȴ�����" + keys[1] + "��������");
				try {
					Thread.sleep(3000);//�߳�����3s
				} catch (Exception e) {
					System.out.println("�߳����߳���" + e.getMessage());
				}
				synchronized (keys[1]) {
					System.out.println("�������ó���" + keys[1] + "���˷�����");
				}
			}
		}
	}

	/**��̬�ػ��߳��ࣨ�ػ�������Ϊ���������ṩ����Ľ��̣�����GC���̣�*/
	static class GoWrong extends Thread {
		public GoWrong() {
			this.setDaemon(true);//����Ϊ�߳��ػ�
		}
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);//�߳�����
				} catch (Exception e) {
					System.out.println("�߳����߳���" + e.getMessage());
				}
				System.out.println("�ػ��̣߳�������������...");
			}
		}
	}
}