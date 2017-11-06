package java_thread;

/**
 * 守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程。
 * 就好像一个公司有销售部，生产部这些和业务挂钩的部门。
 * 除此之外，还有后勤，行政等这些支持部门。
 * 如果一家公司销售部，生产部都解散了，那么只剩下后勤和行政，那么这家公司也可以解散了。
 * 守护线程就相当于那些支持部门，如果一个进程只剩下守护线程，那么进程就会自动结束。
 * 守护线程通常会被用来做日志，性能统计等工作。
 */

public class ThreadDaemon {
	public static void main(String[] args) throws InterruptedException {
		ThreadNew t1= new ThreadNew();
		//设置当前线程为守护线程，该线程会在其它进程全部结束之后自动结束
		t1.setDaemon(true);
		t1.setName("Thread-1");
		t1.start();

		ThreadNew t2= new ThreadNew();
		t2.setName("Thread-2");
		t2.start();

		ThreadNew t3= new ThreadNew();
		t3.setName("Thread-3");
		t3.start();
	}
}

/**线程类*/
class ThreadNew extends Thread{
	@Override
	public void run(){
		int cnt =0;
		boolean run = true;
		while(run){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf(this.getName()+"已经进行了  %d 秒%n", cnt++);
			if(cnt>5 && this.getName().equals("Thread-2")){
				run = false;
			}
			if(cnt>10 && this.getName().equals("Thread-3")){
				run = false;
			}
		}
	}
}