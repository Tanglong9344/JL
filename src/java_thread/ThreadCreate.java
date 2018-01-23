package java_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadCreate {
	//This is a test
	public static void main(String[] args) throws InterruptedException {
		//ThreadX
		Thread tx = new Thread(new ThreadX());
		tx.start();

		//ThreadY
		ThreadY ty = new ThreadY();
		ty.startThreadY();
		Thread.sleep(1000);
		ty.stopThreadY();

	}
}

/**
 * ʵ��java.lang.Runnable�ӿڶ����߳�
 *
 * @author ����
 */
class ThreadX implements Runnable {
	@Override
	public void run() {
		System.out.println("�߳�X�Ѿ�����...");
		System.out.println("����ʱ��:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}
}

/** �̳�java.lang.Thread�ඨ���߳� */
class ThreadY extends Thread {
	private boolean isRunState = false;//����߳��Ƿ���Ҫ����
	@Override
	public void start() {
		this.isRunState = true;//��isRunStateState��Ϊture����ʾ�߳���Ҫ����
		super.start();
	}
	@Override
	public void run() {
		int i = 0;
		try {
			while (isRunState) {
				this.setName("Thread-" + (++i));
				System.out.println("�߳�Y��" + this.getName() + " ��������");
				Thread.sleep(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + "���н���...");
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

	public void setRunning(boolean isRunStateState) {
		this.isRunState = isRunStateState;
	}
}