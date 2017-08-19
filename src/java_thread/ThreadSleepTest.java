package java_thread;

public class ThreadSleepTest {
	public static void main(String[] args) {
		Thread t1= new Thread(){
			@Override
			public void run(){
				int seconds =0;
				boolean run = true;
				while(run){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("已经进行了 %d 秒%n", seconds++);
					//如果超过一分钟则退出
					if(seconds>60){
						System.out.printf("已经进行了 %d 分钟,再见!%n", seconds/60);
						run = false;
					}
				}
			}
		};
		t1.start();
	}
}
