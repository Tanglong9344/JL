package java_reflection;

public class Hero {
	private String name;
	public int age;

	public Hero(){}
	// ����һ����ʼ��name�Ĺ��췽��
	public Hero(String name) {
		this.name = name;
	}

	// ��дtoString����
	@Override
	public String toString() {
		return name;
	}

	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}