package java_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		final int N = 10;
		//获取线程池对象
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		//创建线程
		for(int i=0;i<N;i++){
			executorService.execute(new MyThread());
		}
		//关闭线程池
		executorService.shutdown();
	}
}

/**线程类*/
class MyThread extends Thread{
	@Override
	public void run(){
		System.out.println("线程名："+this.getName());
	}
}