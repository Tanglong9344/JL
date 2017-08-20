package java_thread;

public class ThreadWaitAndNotifyTest {
	public static void main(String[] args) {
		final Hero5 gareen = new Hero5();
		gareen.name = "¸ÇÂ×";
		gareen.hp = 10;

		Thread t1 = new Thread(){
			@Override
			public void run(){
				while(true){
					gareen.hurt();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();

		Thread t2 = new Thread(){
			@Override
			public void run(){
				while(true){
					gareen.recover();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
	}
}