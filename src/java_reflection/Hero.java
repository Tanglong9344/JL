package java_reflection;

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
		System.out.println("初始化 copyright");
		copyright = "版权由Games公司所有";
	}
}
