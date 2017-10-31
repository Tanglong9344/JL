/**
 * 装饰模式
 * 动态地给一个对象添加一些额外的功能
 * 有效的将类的核心功能和装饰功能分离
 * 将装饰功能放在单独的类中，根据需要进行动态装饰。
 */

package design_mode;

public class DecorateMode {
	//This is a test
	public static void main(String[] args) {
		SpecificComponent specificComponent = new SpecificComponent();//组件实现类
		SpecificDecoratorA specificDecoratorA = new SpecificDecoratorA();//装饰实现类A
		SpecificDecoratorB specificDecoratorB = new SpecificDecoratorB();//装饰实现类B

		//装饰组件类
		specificDecoratorA.setCompoent(specificComponent);
		specificDecoratorB.setCompoent(specificDecoratorA);
		specificDecoratorB.Operation();
	}
}

//组件接口
interface Component{
	public void Operation();
}

//组件实现类
class SpecificComponent implements Component{
	@Override
	public void Operation() {
		System.out.println("组件实现类。");
	}

}

//抽象装饰类
abstract class Decorator implements Component{
	protected Component component;
	public void setCompoent(Component component){
		this.component=component;
	}
	@Override
	public void Operation(){
		if(component!=null){
			component.Operation();
		}
	}
}

//具体装饰类A
class SpecificDecoratorA extends Decorator{
	@SuppressWarnings("unused")
	private String status;//类A独有的属性，区别于其他实现类
	@Override
	//先执行父类的Operation()在执行本类的操作
	//相当于对原来的Component进行了装饰
	public void Operation(){
		super.Operation();
		status="New Status.";
		System.out.println("具体装饰类A。");
	}
}

//具体装饰类B
class SpecificDecoratorB extends Decorator{
	@Override
	public void Operation(){
		super.Operation();
		addBehavior();
		System.out.println("具体装饰类B。");
	}

	//类B独有的方法，区别于其他实现类
	private void addBehavior(){}
}