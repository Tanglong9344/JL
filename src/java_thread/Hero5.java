package java_thread;

public class Hero5 {
	public String name;
	public float hp;
	public int damage;

	//加血操作
	public synchronized void recover() {
		hp = hp + 1;
		System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
		// 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
		this.notify();
	}

	//减血操作
	public synchronized void hurt() {
		if (1 == hp) {
			try {
				// 让占有this的减血线程，暂时释放对this的占有，并等待
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hp = hp - 1;
		System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
	}
	//攻击操作
	public void attackHero(Hero5 h) {
		h.hp -= damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name + "死了！");
		}
	}
	//判断血量是否小于0
	public boolean isDead() {
		return hp<=0? true : false;
	}
}
