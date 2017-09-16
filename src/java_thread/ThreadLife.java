package java_thread;

import java.util.Date;

public class ThreadLife {
	public void startY() {
		ThreadY ty = new ThreadY();
		ty.startThreadY(); // ����ThreadY�߳�
		try {
			Thread.sleep(1000); // ��ǰ�߳�����һ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ty.stopThreadY(); // ֹͣThreadY�߳�
	}

	public void startX() { // ��ʼ�ڶ���
		Runnable runnX = new ThreadX(); // ����ʵ��
		Thread threadX = new Thread(runnX); // ��ʵ�������߳���
		threadX.start(); // start���������߳�
	}

	public static void main(String[] args) { // java��������ڴ�
		ThreadLife test = new ThreadLife(); // ʵ��������
		test.startY(); // ���÷���
		test.startX();
	}

}

/**
 * �̳�java.lang.Thread�ඨ���߳�
 * @author ����
 */
class ThreadY extends Thread {
	private boolean isRunState = false; // ����߳��Ƿ���Ҫ����
	@Override
	public void start() {
		this.isRunState = true; // ��isRunState��Ϊture����ʾ�߳���Ҫ����
		super.start();
	}
	@Override
	public void run() {
		int i = 0;
		try {
			// ���isRunStateΪ�棬˵���̻߳����Լ�������
			while (isRunState) {
				this.setName("Thread-" + i++);
				System.out.println("�߳�Y��" + this.getName() + " ��������");
				Thread.sleep(200); // sleep��������ǰ�߳����ߡ�
			}
		} catch (Exception e) {
		}
		System.out.println(this.getName() + "���н���...");
	}

	public void setRunning(boolean isRunState) {
		this.isRunState = isRunState;
	}

	// ����ThreadY�߳�
	public void startThreadY() {
		System.out.println("�����߳�Y...");
		this.start();
	}

	// ֹͣThreadY�߳�
	public void stopThreadY() {
		System.out.println("�����߳�Y...");
		this.setRunning(false);
	}
}

/**
 * ʵ��java.lang.Runnable�ӿڶ����߳�
 * @author ����
 */
class ThreadX implements Runnable {
	private Date runDate; // �̱߳����е�ʱ��
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		System.out.println("�߳�X�Ѿ�����...");
		this.runDate = new Date();
		System.out.println("����ʱ��:" + runDate.toLocaleString());
	}
}