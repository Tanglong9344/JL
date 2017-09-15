package something_interesting;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerThread {
	public static void main(String[] args) {
		Timer timer = new Timer(); // 创建定时器类
		TimerTask t1 = new MyTask(1);
		timer.schedule(t1, 200); // 0.2秒后执行任务
		TimerTask t2 = new MyTask(2);
		timer.schedule(t2, 500, 1000); // 0.5秒后执行任务并每个1秒执行一次
		TimerTask t3 = new MyTask(3);
		Date date = new Date(System.currentTimeMillis() + 1000);
		timer.schedule(t3, date); // 在指定时间1秒后执行任务
		try {
			Thread.sleep(3000); // 休眠3秒钟
		} catch (InterruptedException e) { // 捕获拦截异常
			System.out.println("出现错误：" + e.getMessage());
		}
		timer.cancel(); // 终止定时器取消定时器中的任务
		System.out.println("任务定时器已经被取消");
	}
}

/**
 * 继承时间任务类执行任务
 * @author 唐龙
 */
class MyTask extends TimerTask {
	private int taskID = 0; // 任务编号
	public MyTask(int id) {
		this.taskID = id;
	}
	@Override
	@SuppressWarnings("deprecation")
	public void run() {
		System.out.println("开始执行我的第" + this.taskID + "个任务 ，执行时间为" + new Date().toLocaleString());
	}
}