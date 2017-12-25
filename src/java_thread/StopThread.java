package java_thread;

import java.util.concurrent.TimeUnit;

/**
 * Thread synchronized stop
 *
 * @author ÌÆÁú
 *
 */
public class StopThread {
	private static boolean stopRequested = false;

	/**set stopRequested's value to true*/
	private static synchronized void requestStop(){
		stopRequested = true;
	}

	/**return stopRequested's value*/
	private static synchronized boolean stopRequested(){
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				int i = 0;
				while(!stopRequested()){
					System.out.printf("%3d ", i++);
					if(i%10 == 0) {
						System.out.println();
					}
				}
			}
		});
		thread.start();
		TimeUnit.MILLISECONDS.sleep(100);//sleep for 100ms
		requestStop();
	}
}