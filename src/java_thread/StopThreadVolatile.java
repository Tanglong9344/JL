package java_thread;

import java.util.concurrent.TimeUnit;

/**
 * Thread stop volatile
 *
 * @author ÌÆÁú
 *
 */
public class StopThreadVolatile {
	private static volatile boolean stopRequested = false;
	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				int i = 0;
				while(!stopRequested){
					System.out.printf("%3d ", i++);
					if(i%10 == 0) {
						System.out.println();
					}
				}
			}
		});
		thread.start();
		TimeUnit.MILLISECONDS.sleep(100); //sleep for 100ms
		stopRequested = true;
	}
}