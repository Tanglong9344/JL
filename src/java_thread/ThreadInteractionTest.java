package java_thread;

public class ThreadInteractionTest {
	public static void main(String[] args) {

		final Hero4 gareen = new Hero4();
		gareen.name = "盖伦";
		gareen.hp = 10;
		//线程1减血
		Thread t1 = new Thread(){
			@Override
			public void run(){
				while(true){
					//因为减血更快，所以盖伦的血量迟早会到达1
					//使用while循环判断是否是1，如果是1就不停的循环
					//直到加血线程回复了血量
					while(1 == gareen.hp){
						continue;
					}
					gareen.hurt();
					System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		//线程2加血
		Thread t2 = new Thread(){
			@Override
			public void run(){
				while(true){
					gareen.recover();
					System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",gareen.name,gareen.name,gareen.hp);
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