package java_core_basic;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 延时的两种方法
 * @author 唐龙
 */
public class TimeDelay {
	public static void main(String[] args) {
		delaySleep();
		delayTimer();
	}

	// 使用Thread.sleep()延时
	private static void delaySleep(){
		Thread.currentThread();
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(500);// 延时0.5s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("i=" + i+" ");
		}
		System.out.println();
	}

	// 使用Timer对象延时(更精确)
	private static void delayTimer(){
		for (int i = 0; i <= 10; i++) {
			Timer timer = new Timer();// 实例化Timer类
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					this.cancel();
				}
			}, 500, 500);// 延时0.5s
			System.out.print("i=" + i+" ");
		}
		System.out.println();
	}
}