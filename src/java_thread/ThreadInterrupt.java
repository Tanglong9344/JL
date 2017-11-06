package java_thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadInterrupt extends Thread {
	//This is a test
	public static void main(String[] args) {
		Interrupt relay = new Interrupt();
		relay.start();// 启动线程
		try {
			relay.join();//等待线程运行结束
		} catch (InterruptedException e) {
			System.out.println(" 收到命令，准备上场：" + e.getMessage());
		}
		relay.incident();//调用方法判断是否唤醒
	}
}

/**
 * 线程唤醒测试
 * @author 唐龙
 */
class Interrupt extends Thread{
	//在程序中假设1秒钟=1小时
	private DateFormat df = new SimpleDateFormat("ss:SS");
	@Override
	public void run() {
		System.out.println("第一场比赛结束的时间为：" + df.format(new Date()));
		System.out.println("休息2小时");
		try {
			sleep(2000);//线程休眠2秒 在程序假设1秒钟=1小时
		} catch (InterruptedException e) {
			System.out.println(df.format(new Date())+"收到命令，准备上场："+e.getMessage());
		}
		System.out.print(df.format(new Date()) + "在休息的过程中是否又参加其他的比赛? ");
		try {
			sleep(2000);// 线程休眠2秒
		} catch (InterruptedException e) {
			System.out.println(df.format(new Date()) + "收到命令，准备上场：" + e.getMessage());
		}
		System.out.println(!isAlive() ? "是" : "没有参加其他的比赛");//线程是否激活,false表不是激活的
		interrupt();// 唤醒线程
		System.out.print(df.format(new Date()) + " 休息中，替补队员受伤，是否参加比赛? ");
		System.out.println(isAlive() ? "参加比赛" : "不参加比赛");
	}

	/**根据条件唤醒进程*/
	public void incident() {
		//唤醒当前线程
		Thread.currentThread().interrupt();
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.print(df.format(new Date()) + "现在是否正在准备上场?");
				System.out.println(Thread.currentThread().isInterrupted() ? "是" : "没有");
				try {
					Thread.currentThread();
					Thread.sleep(3000);//线程休眠3秒
				} catch (InterruptedException e) {
					System.out.println(df.format(new Date()) + "收到命令，停止休息："+ e.getMessage());
				}
				System.out.print(df.format(new Date()) + "比赛结束后是否参加下一轮比赛? ");
				System.out.println(Thread.currentThread().isInterrupted() ? "参加" : "不参加");
			}
		}
	}
}