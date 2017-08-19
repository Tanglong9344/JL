package java_reflection;

public class Hero2 implements Comparable<Hero2>{
	public String name; 
	public float hp;
	public int damage;

	public Hero2(){}

	public Hero2(String name) {this.name =name;}

	//初始化name,hp,damage的构造方法
	public Hero2(String name,float hp, int damage) {
		this.name =name;
		this.hp = hp;
		this.damage = damage;
	}

	@Override
	public int compareTo(Hero2 anotherHero) {
		if(damage<anotherHero.damage)
			return 1;  
		else
			return -1;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	}
}
