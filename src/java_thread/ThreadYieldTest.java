package java_thread;

public class ThreadYieldTest {
	public static void main(String[] args) {
		final Hero2 gareen = new Hero2();
		gareen.name = "����";
		gareen.hp = 600;
		gareen.damage = 10;

		final Hero2 teemo = new Hero2();
		teemo.name = "��Ī";
		teemo.hp = 300;
		teemo.damage = 10;

		final Hero2 bh = new Hero2();
		bh.name = "�ͽ�����";
		bh.hp = 500;
		bh.damage = 10;

		final Hero2 leesin = new Hero2();
		leesin.name = "äɮ";
		leesin.hp = 300;
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
					//��ʱ��ͣ��ʹ��t1����ռ��CPU��Դ
					Thread.yield();
					bh.attackHero(leesin);
				}
			}
		};
		t1.setPriority(5);
		t2.setPriority(5);
		t1.start();
		t2.start();
	}
}
