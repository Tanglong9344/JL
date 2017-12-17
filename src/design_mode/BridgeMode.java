package design_mode;

/**
 * 桥接模式
 * 将抽象部分和它的实现部分分离，使得他们可以独立的变化。
 *
 * 实现系统可能多角度分类，每一种分类都有可能变化，
 * 那么就把这种多角度分离出来让他们独立变化，减少它们之间的耦合。
 *
 * @author 唐龙
 *
 */
public class BridgeMode {
	//This is a test
	public static void main(String[] args) {
		//抽象类对象
		Abstraction abstraction=new Abstraction();
		//抽象实现类A
		abstraction.setImplementor(new SpecificImplementorA());
		abstraction.operation();

		//抽象实现类B
		abstraction.setImplementor(new SpecificImplementorB());
		abstraction.operation();
	}
}

//抽象实现类
abstract class Implementor{
	public abstract void operation();
}

//具体实现类A
class SpecificImplementorA extends Implementor{
	@Override
	public void operation() {
		System.out.println("具体实现A的执行方法。");
	}
}

//具体实现类B
class SpecificImplementorB extends Implementor{
	@Override
	public void operation() {
		System.out.println("具体实现B的执行方法。");
	}
}

//抽象类
class Abstraction{
	protected Implementor implementor;
	public void setImplementor(Implementor implementor){
		this.implementor=implementor;
	}

	public void operation(){
		implementor.operation();
	}
}