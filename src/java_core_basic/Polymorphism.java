package java_core_basic;

public class Polymorphism {
	public static void main(String[] args) {
		Polymorphism p = new Polymorphism();
		System.out.println("---------¶àÌ¬---------");
		System.out.println(p.add(1));
		System.out.println(p.add(1,2));
		System.out.println(p.add(1,2,3));
	}

	//add(int a)
	public int add(int a){
		System.out.println("add(int a): one parameter");
		return a;
	}

	//add(int a,int b)
	public int add(int a,int b){
		System.out.println("add(int a,int b): two parameters");
		return a + b;
	}

	//add(int a,int b,int c)
	public int add(int a,int b,int c){
		System.out.println("add(int a,int b,int c): three parameters");
		return a + b + c;
	}
}