package java_thread;

public class KillThread extends Thread{
	private Hero h1;
	private Hero h2;
	public KillThread(Hero h1, Hero h2){
		this.h1 = h1;
		this.h2 = h2;
	}

	@Override
	//重写线程执行方法
	public void run(){
		while(!h2.isDead()){
			h1.attackHero(h2);
		}
	}
}
