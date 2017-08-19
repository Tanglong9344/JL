package java_core_basic;

import java.util.Timer;
import java.util.TimerTask;

public class TimeDelay2Test {
	public static void main(String[] args) {
		// 延时2(更精确)
		for (int i = 0; i <= 10; i++) {
			Timer timer = new Timer();// 实例化Timer类
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					this.cancel();
				}
			}, 500, 500);// 延时0.5s
			System.out.println("i=" + i);
		}
	}
}