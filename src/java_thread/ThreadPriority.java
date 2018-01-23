package java_thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Thread priority
 *
 * @author 唐龙
 *
 */
public class ThreadPriority {
	//This is a test
	public static void main(String[] args) {
		final int N=10;
		List<ThreadP> tList = new ArrayList<ThreadP>();
		for(int i=1;i<=N;i++){
			ThreadP tp = new ThreadP("Thread"+i);
			//设置优先级
			tp.setPriority((new java.util.Random().nextInt(N)+1));
			tList.add(tp);
		}
		//启动
		tList.forEach(tp->tp.start());
	}
}

/**线程类*/
class ThreadP extends Thread{
	public ThreadP(String name){
		super(name);
	}

	@Override
	public void run(){
		int a=6;
		while((a--)>0){
			System.out.println("线程名：" + this.getName()+" 优先级：" + stars(this.getPriority()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**get some stars*/
	private String stars(long num) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<num;i++) {
			sb.append("☺");
		}
		return sb.toString();
	}
}