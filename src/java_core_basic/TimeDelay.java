package java_core_basic;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ��ʱ�����ַ���
 * @author ����
 */
public class TimeDelay {
	public static void main(String[] args) {
		delaySleep();
		delayTimer();
	}

	// ʹ��Thread.sleep()��ʱ
	private static void delaySleep(){
		Thread.currentThread();
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(500);// ��ʱ0.5s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("i=" + i+" ");
		}
		System.out.println();
	}

	// ʹ��Timer������ʱ(����ȷ)
	private static void delayTimer(){
		for (int i = 0; i <= 10; i++) {
			Timer timer = new Timer();// ʵ����Timer��
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					this.cancel();
				}
			}, 500, 500);// ��ʱ0.5s
			System.out.print("i=" + i+" ");
		}
		System.out.println();
	}
}