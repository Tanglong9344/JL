package java_thread;

public class ThreadJoinTest {
	public static void main(String[] args) {
		final Hero gareen = new Hero();
		gareen.name = "����";
		gareen.hp = 616;
		gareen.damage = 50;

		final Hero teemo = new Hero();
		teemo.name = "��Ī";
		teemo.hp = 300;
		teemo.damage = 30;

		final Hero bh = new Hero();
		bh.name = "�ͽ�����";
		bh.hp = 500;
		bh.damage = 65;

		final Hero leesin = new Hero();
		leesin.name = "äɮ";
		leesin.hp = 455;
		leesin.damage = 80;

		final Hero cc = new Hero();
		cc.name = "�ܲ�";
		cc.hp = 600;
		cc.damage = 60;

		final Hero lb = new Hero();
		lb.name = "����";
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

		//����ִ�е����һֱ��main�߳�������
		try {
			//t1�̼߳��뵽main�߳�������ֻ��t1�߳����н������Ż����������
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
		//��۲쵽���װ���Īɱ���󣬲�����t2��t3�߳�
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
