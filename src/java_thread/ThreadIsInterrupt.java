package java_thread;

import java.util.concurrent.TimeUnit;

/**
 * isInterrupt in Thread
 * interrupt() can give a thread tag that it's interrupted
 * and some code in the thread will handle this according
 * <code>this.isInterrupted()</code>
 *
 * @author ÌÆÁú
 *
 */
public class ThreadIsInterrupt {
	public static void main(String[] args) throws InterruptedException {
		ThreadTest tt = new ThreadTest();
		tt.start();
		TimeUnit.MILLISECONDS.sleep(100);
		tt.interrupt();
	}
}

class ThreadTest extends Thread{
	@Override
	public void run() {
		while (true) {
			System.out.println("Running...");
			if(this.isInterrupted()) {
				System.out.println("Interrupt...");
				return;
			}
		}
	}
}