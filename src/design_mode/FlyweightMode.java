package design_mode;

import java.util.Hashtable;

/**
 * 享元模式
 * 运用共享技术有效地支持大量细粒度的对象
 *
 * 在享元对象内部并且不会随环境改变而改变的共享部分是享元对象的内部状态
 * 而随环境改变而变化且不可共享的状态是外部状态。
 * 享元模式可以避免大量非常相似类的开销。
 * 在程序设计中，有时需要生成大量细粒度的类实例来表示数据。
 * 如果能够发现这些实例除了几个参数外其他部分基本相同
 * 通过这些参数移到类实例的外面，在方法调用时将它们传递进来的方法，
 * 就可以通过共享大幅度地减少实例化类的数量。
 *
 * @author 唐龙
 *
 */
public class FlyweightMode {
	//This is a test
	public static void main(String[] args) {
		//享元类状态
		int state=0;
		//享元类工厂
		FlyweightFactory factory=new FlyweightFactory();
		//享元类
		Flyweight flyweightA=factory.getFlyweight("A");
		flyweightA.operation(++state);

		//享元类
		Flyweight flyweightB=factory.getFlyweight("B");
		flyweightB.operation(++state);

		UnsharedSpecificFlyweight unFlyweight=new UnsharedSpecificFlyweight();
		unFlyweight.operation(++state);
	}
}

//抽象享元类
abstract class Flyweight{
	public abstract void operation(int state);
}

//具体享元类
class SpecificFlyweight extends Flyweight{
	@Override
	public void operation(int state) {
		System.out.println("具体享元类，状态："+state);
	}
}

//具体不共享享元类
class UnsharedSpecificFlyweight extends Flyweight{
	@Override
	public void operation(int state) {
		System.out.println("不共享具体享元类，状态："+state);
	}
}

//享元工厂类，用来创建和管理享元类
class FlyweightFactory{
	private Hashtable<String,Object> flyweights = new Hashtable<String,Object>();

	//获取享元类对象
	public Flyweight getFlyweight(String key){
		if(flyweights.get(key)==null){
			flyweights.put(key,new SpecificFlyweight());
		}
		return (Flyweight)flyweights.get(key);
	}
}