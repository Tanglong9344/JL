package java_thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Relay extends Thread {
	private DateFormat df = new SimpleDateFormat("ss:SS");
	public static void main(String[] args) {
		Relay relay = new Relay();
		relay.start();// �����߳�
		try {
			relay.join(); // �ȴ��߳����н���
		} catch (InterruptedException e) {
			System.out.println(" �յ����׼���ϳ���" + e.getMessage());
		}
		relay.incident();// ���÷����ж��Ƿ���
	}

	/**
	 * �����������ѽ���
	 */
	public void incident() {
		Thread.currentThread().interrupt();
		while (true) {
			if (Thread.currentThread().isInterrupted()) { // �жϵ�ǰ�߳��Ƿ񱻻���
				System.out.print(df.format(new Date()) + "	�����Ƿ�����׼���ϳ�? ");
				System.out.println(Thread.currentThread().isInterrupted() ? "��": "û��");
				try {
					Thread.currentThread();
					Thread.sleep(3000); // �߳�����3��
				} catch (InterruptedException e) {
					System.out.println(df.format(new Date()) + " �յ����ֹͣ��Ϣ��"+ e.getMessage());
				}
				System.out.print(df.format(new Date()) + "	�����������Ƿ�μ���һ�ֱ���? ");
				System.out.println(Thread.currentThread().isInterrupted() ? "��": "���μ�");
			}
		}
	}
	@Override
	public void run() {
		System.out.println("��һ������������ʱ��Ϊ��" + df.format(new Date()));
		System.out.println("��Ϣ2Сʱ");
		try {
			sleep(2000);// �߳�����2�� �ڳ������1����=1Сʱ
		} catch (InterruptedException e) {
			System.out.println(df.format(new Date()) + "�յ����׼���ϳ���"
					+ e.getMessage());
		}
		System.out.print(df.format(new Date()) + "����Ϣ�Ĺ������Ƿ��ֲμ������ı���? ");
		try {
			sleep(2000);// �߳�����2��
		} catch (InterruptedException e) {
			System.out.println(df.format(new Date()) + "�յ����׼���ϳ���" + e.getMessage());
		}
		System.out.println(!isAlive() ? "�μӱ���" : "û�вμ������ı���"); // �߳��Ƿ񼤻�,false���Ǽ����
		interrupt();// �����߳�
		System.out.print(df.format(new Date()) + " ��Ϣ�У��油��Ա���ˣ��Ƿ�μӱ���? ");
		System.out.println(isAlive() ? "�μӱ���" : "���μӱ���"); // �߳��Ƿ񼤻�
	}
}