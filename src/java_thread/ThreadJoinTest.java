package java_thread;

public class ThreadJoinTest {
	public static void main(String[] args) {
		final Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.hp = 616;
		gareen.damage = 50;

		final Hero teemo = new Hero();
		teemo.name = "提莫";
		teemo.hp = 300;
		teemo.damage = 30;

		final Hero bh = new Hero();
		bh.name = "赏金猎人";
		bh.hp = 500;
		bh.damage = 65;

		final Hero leesin = new Hero();
		leesin.name = "盲僧";
		leesin.hp = 455;
		leesin.damage = 80;

		final Hero cc = new Hero();
		cc.name = "曹操";
		cc.hp = 600;
		cc.damage = 60;

		final Hero lb = new Hero();
		lb.name = "刘备";
		lb.hp = 800;
		lb.damage = 100;

		Thread t1= new Thread(){
			@Override
			public void run(){
				while(!teemo.isDead()){
					gareen.attackHero(teemo);
				}
			}
		};
		t1.start();

		//代码执行到这里，一直是main线程在运行
		try {
			//t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Thread t2= new Thread(){
			@Override
			public void run(){
				while(!leesin.isDead()){
					bh.attackHero(leesin);
				}
			}
		};
		//会观察到盖伦把提莫杀掉后，才运行t2和t3线程
		t2.start();

		Thread t3= new Thread(){
			@Override
			public void run(){
				while(!lb.isDead()){
					cc.attackHero(lb);
				}
			}
		};
		t3.start();
	}
}
