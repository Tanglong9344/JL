/**
 * 外观模式
 * 为子系统中的一组接口提供一个一致的界面。
 * 此模式定义了一个高层接口，使得子系统更加容易使用。
 */

package design_mode;

public class FacadeMode {
	//This is a test
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.methodA();
		facade.methodB();
	}
}

//子系统类A
class SubSystemA{
	public void methodA(){
		System.out.println("子系统A的方法A。");
	}
}

//子系统类B
class SubSystemB{
	public void methodB(){
		System.out.println("子系统B的方法B。");
	}
}

//子系统类C
class SubSystemC{
	public void methodC(){
		System.out.println("子系统C的方法C。");
	}
}

//外观类
class Facade{
	SubSystemA subSystemA=null;
	SubSystemB subSystemB=null;
	SubSystemC subSystemC=null;

	//构造方法初始化对象
	public Facade(){
		subSystemA=new SubSystemA();
		subSystemB=new SubSystemB();
		subSystemC=new SubSystemC();
	}

	public void methodA(){
		System.out.println("\n方法组methodA()。\n----------------");
		subSystemA.methodA();
		subSystemB.methodB();
		System.out.println("---------------");
	}

	public void methodB(){
		System.out.println("\n方法组methodB()。\n----------------");
		subSystemA.methodA();
		subSystemC.methodC();
		System.out.println("---------------");
	}
}