package java_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		final int N = 10;
		//��ȡ�̳߳ض���
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		//�����߳�
		for(int i=0;i<N;i++){
			executorService.execute(new MyThread());
		}
		//�ر��̳߳�
		executorService.shutdown();
	}
}

/**�߳���*/
class MyThread extends Thread{
	@Override
	public void run(){
		System.out.println("�߳�����"+this.getName());
	}
}