package java_collection;

public class Hero {
	public String name;
	public float hp;
	public int damage;

	public Hero() {}
	public Hero(String name,int damage){
		this.name = name;
		this.damage = damage;
	}
	// 增加一个初始化name的构造方法
	public Hero(String name) {
		this.name = name;
	}
	// 重写toString方法
	@Override
	public String toString() {
		return name;
	}
}