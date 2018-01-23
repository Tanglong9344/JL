package java_thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//从0s时刻开始每间隔1s执行一次
		timer.schedule(new ScheduleTask("重复任务"),0,1*1000);
		//在5s时刻执行
		timer.schedule(new ScheduleTask("定时任务"),5000);
	}
}

/**
 * 待执行的任务
 *
 * 继承TimerTask
 *
 * @author 唐龙
 *
 */
class ScheduleTask extends TimerTask{
	private String msg;
	public ScheduleTask(String msg){
		this.msg=msg;
	}

	@Override
	public void run() {
		System.out.println("执行-"+msg);
	}
}