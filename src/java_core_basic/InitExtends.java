package java_core_basic;

/**
 * 初始化执行顺序
 *  标号代表执行次序
 *  按照先静态再继承的顺序初始化
 * @author 唐龙
 */
public class InitExtends {
	public static void main(String[] args) {
		new InitExtends();
	}

	// 实例初始化块
	{
		System.out.println("类extendsInitTest的实例初始化块。");//2
	}

	// 静态初始化块
	static {
		System.out.println("类extendsInitTest的静态初始化块。");//1
	}

	// 父类子类初始化
	public InitExtends(){
		new Child();
	}
}

/** child class */
class Child extends Father{
	{
		System.out.println("类Child的实例初始化块。");//8
	}

	static {
		System.out.println("类Child的静态初始化块。");//4
	}

	Child(){
		System.out.println("类Child的构造方法。");//9
	}
}

/**father class*/
class Father{
	private int age;

	{
		System.out.println("类Father的实例初始化块。");//5
	}

	static {
		System.out.println("类Father的静态初始化块。");//3
	}

	Father(){
		this(30);
		System.out.println("类Father的构造方法Father()。");//7
	}

	Father(int age){
		this.setAge(age);
		System.out.println("类Father的构造方法Father(int)。");//6
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}