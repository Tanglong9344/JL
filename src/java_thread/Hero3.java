package java_thread;

public class Hero3 {
	public String name;
	public float hp;
	public int damage;

	//��Ѫ
	public void recover(){
		hp=hp+1;
	}

	//��Ѫ
	public void hurt(){
		hp=hp-1;
	}

	public void attackHero(Hero h) {
		h.hp-=damage;
		System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n",name,h.name,h.name,h.hp);
		if(h.isDead()) {
			System.out.println(h.name +"���ˣ�");
		}
	}

	public boolean isDead() {
		return hp<=0?true:false;
	}
}