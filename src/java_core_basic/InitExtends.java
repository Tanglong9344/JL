package java_core_basic;

/**
 * �̳г�ʼ��ִ��˳��
 * ��Ŵ���ִ�д���
 * �����Ⱦ�̬�ټ̳е�˳���ʼ��
 */
public class InitExtends {
	public static void main(String[] args) {
		new InitExtends();
	}
	{
		System.out.println("��extendsInitTest��ʵ����ʼ���顣");//2
	}
	static {
		System.out.println("��extendsInitTest�ľ�̬��ʼ���顣");//1
	}
	public InitExtends(){
		new Child();
	}
}

/**
 * child class
 */
class Child extends Father{
	{
		System.out.println("��Child��ʵ����ʼ���顣");//8
	}
	static {
		System.out.println("��Child�ľ�̬��ʼ���顣");//4
	}
	Child(){
		System.out.println("��Child�Ĺ��췽����");//9
	}


}

/**
 * father class
 */
class Father{
	private int age;
	{
		System.out.println("��Father��ʵ����ʼ���顣");//5
	}
	static {
		System.out.println("��Father�ľ�̬��ʼ���顣");//3
	}
	Father(){
		this(30);
		System.out.println("��Father�Ĺ��췽��Father()��");//7
	}
	Father(int age){
		this.age = age;
		System.out.println("��Father�Ĺ��췽��Father(int)��");//6
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}