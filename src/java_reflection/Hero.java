package java_reflection;

public class Hero {
	private String name;
	public int age;

	public Hero(){}
	// 增加一个初始化name的构造方法
	public Hero(String name) {
		this.name = name;
	}

	// 重写toString方法
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