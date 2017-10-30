/**
 * 策略模式封装了变化
 * 策略模式定义了一系列算法，并将每个算法封装起来，
 * 使他们可以相互替换 且算法的变化不会影响到使用算法的客户。
 * 需要设计一个接口(或抽象类)，
 * 为一系列实现类提供统一的方法，
 * 多个实现类实现该接口，
 */

package design_mode;

public class StrategyMode {
	public static void main(String[] args) {
		//上下文对象
		Context context=null;
		//实例化A
		context=new Context(new SpecificStrategyA());
		context.contextInterface();

		//实例化B
		context=new Context(new SpecificStrategyB());
		context.contextInterface();

		//实例化C
		context=new Context(new SpecificStrategyC());
		context.contextInterface();
	}
}

//抽象类
abstract class Strategy{
	//抽象方法
	public abstract void algorithomIntegerface();
}

//实现类A
class SpecificStrategyA extends Strategy{
	@Override
	//实现方法
	public void algorithomIntegerface() {
		System.out.println("--SpecificStrategyA.");
	}
}

//实现类B
class SpecificStrategyB extends Strategy{
	@Override
	//实现方法
	public void algorithomIntegerface() {
		System.out.println("--SpecificStrategyB.");
	}
}

//实现类C
class SpecificStrategyC extends Strategy{
	@Override
	//实现方法
	public void algorithomIntegerface() {
		System.out.println("--SpecificStrategyC.");
	}
}

//上下文类
class Context{
	private Strategy strategy=null;
	public Context(Strategy strategy){
		this.strategy=strategy;
	}

	//上下文接口，根据传入的实现类对象调用对应的实现方法
	public void contextInterface(){
		strategy.algorithomIntegerface();
	}
}