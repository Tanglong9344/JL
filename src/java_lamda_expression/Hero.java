package java_lamda_expression;

public class Hero {
	public String name;
	public float hp;
	public int damage;

	public Hero() {}

	public Hero(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	}

	public Hero(String name, int hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	static String copyright;
	static {
		System.out.println("��ʼ�� copyright");
		copyright = "��Ȩ�� Games��˾����";
	}
	//����hp>100��damage<50��Hero
	public boolean matched() {
		return hp>100 && damage<50;
	}
}
