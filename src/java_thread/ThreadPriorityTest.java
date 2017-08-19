package java_thread;

public class ThreadPriorityTest {
	public static void main(String[] args) {

		final Hero2 gareen = new Hero2();
		gareen.name = "¸ÇÂ×";
		gareen.hp = 120;
		gareen.damage = 10;

		final Hero2 teemo = new Hero2();
		teemo.name = "ÌáÄª";
		teemo.hp = 600;
		teemo.damage = 10;

		final Hero2 bh = new Hero2();
		bh.name = "ÉÍ½ðÁÔÈË";
		bh.hp = 100;
		bh.damage = 10;

		final Hero2 leesin = new Hero2();
		leesin.name = "Ã¤É®";
		leesin.hp = 800;
		leesin.damage = 10;

		Thread t1= new Thread(){
			@Override
			public void run(){

				while(!teemo.isDead()){
					gareen.attackHero(teemo);
				}
			}
		};

		Thread t2= new Thread(){
			@Override
			public void run(){
				while(!leesin.isDead()){
					bh.attackHero(leesin);
				}
			}
		};

		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Thread.MAX_PRIORITY:"+Thread.MAX_PRIORITY);

		t2.setPriority(Thread.MIN_PRIORITY);
		System.out.println("Thread.MIN_PRIORITY:"+Thread.MIN_PRIORITY);

		t1.start();
		t2.start();
	}
}
