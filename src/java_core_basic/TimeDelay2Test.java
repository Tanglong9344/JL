package java_core_basic;

import java.util.Timer;
import java.util.TimerTask;

public class TimeDelay2Test {
	public static void main(String[] args) {
		// ��ʱ2(����ȷ)
		for (int i = 0; i <= 10; i++) {
			Timer timer = new Timer();// ʵ����Timer��
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					this.cancel();
				}
			}, 500, 500);// ��ʱ0.5s
			System.out.println("i=" + i);
		}
	}
}