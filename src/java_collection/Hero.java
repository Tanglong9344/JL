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
	// ����һ����ʼ��name�Ĺ��췽��
	public Hero(String name) {
		this.name = name;
	}
	// ��дtoString����
	@Override
	public String toString() {
		return name;
	}
}