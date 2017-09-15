package java_thread;

public class Transformer {
	public static void main(String[] args) {
		Defensor defensor = new Defensor();
		defensor.start();
		try {
			Thread.sleep(500);//����5s
		} catch (InterruptedException e) {
			System.out.println("�����쳣:" + e.getMessage());
		}
	}
}

/**
 * �����ػ����̵߳���
 * @author ����
 */
class Defensor extends Thread {
	@Override
	public void run() {
		System.out.print("�����컢��Ϯ�������Σ�ѹ�ͷ���ػ����Ƿ��ȡ���ұ���? ");
		System.out.println(this.isDaemon() ? "��" : "û��");// ���Ը��߳��Ƿ�Ϊ�ػ��̡߳�
		System.out.println("�ػ���Defensor�ǻ������������սʿ������������Ը�������Լ�ȥ��������");
		Human people = new Human();
		people.setDaemon(true); // �����ػ��̣߳��ڱ������н�������people����Ϊ�ػ��߳�Ҳ���Ǳ������Ķ���
		people.start();// �����ػ��߳�
		try {
			Thread.sleep(1000); // ����1��
		} catch (InterruptedException e) { // �������쳣
			System.out.println("�����쳣:" + e.getMessage());
		} finally {
			System.out.println("�����Σ�յ�ʱ���غ������������򣬱�������İ�ȫ");
		}
		System.out.println("�غ���̫ΰ����...");
	}
}

/**
 * �������
 * @author ����
 */
class Human extends Thread {
	static final int NUM = 5;
	@Override
	public void run() {
		System.out.print("����İ�ȫ�Ƿ񱻱�����");
		System.out.println(this.isDaemon() ? "��" : "û��");// �жϴ��߳��Ƿ����ػ��߳�
		System.out.printf("������%d������������������Σ��֮�У�����%n",NUM);
		int i = 0;
		try {
			while (i < NUM) {
				System.out.println("��" + (1 + i++) + "������������");
				Thread.sleep(200); // ����0.2��
			}
		} catch (InterruptedException e) {
			System.out.println("�����쳣:" + e.getMessage());
		} finally {
			System.out.println("�غ����ľ������������లȫ�Ķ�����컢�ķ��Ϯ��");
		}
		System.out.println("��������Σ���ˡ�����");
	}
}