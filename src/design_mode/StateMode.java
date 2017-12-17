package design_mode;

/**
 * 状态模式
 * 当一个对象的内在状态变化时允许改变其行为
 * 这个对象看起来像是改变了其类
 *
 * 状态模式主要解决的是当控制一个对象转换的条件表达式过与复杂时的情况。
 * 把状态的判断逻辑转移到表示不同状态的一系列类当中，可以吧复杂的判断逻辑简化。
 *
 * 状态模式的好处是将与特定状态相关的行为局部化，并且将不同状态的行为分割开来(即放在不同类中)
 * 适用场景：当一个对象的行为取决于它的状态并且必须在运行时刻根据具体状态改变它的行为时。
 *
 * @author 唐龙
 *
 */
public class StateMode {
	//This is a test
	public static void main(String[] args) {
		//初始状态为A
		ContextState contextState=new ContextState(new SpecificStateA());
		//不断更新状态(在A,B,C之间不断切换)
		for(int i=0;i<10;i++){
			contextState.reauest();
		}
	}
}

//抽象状态转换类
abstract class State{
	public abstract void handle(ContextState ContextState);
}

//具体状态转换类A
class SpecificStateA extends State{
	@Override
	public void handle(ContextState ContextState) {
		System.out.println("当前状态：状态A");
		//转换到下一个状态
		ContextState.setState(new SpecificStateB());
	}
}

//具体状态转换类B
class SpecificStateB extends State{
	@Override
	public void handle(ContextState ContextState) {
		System.out.println("当前状态：状态B");
		//转换到下一个状态
		ContextState.setState(new SpecificStateC());
	}
}

//具体状态转换类C
class SpecificStateC extends State{
	@Override
	public void handle(ContextState ContextState) {
		System.out.println("当前状态：状态C");
		//转换到下一个状态
		ContextState.setState(new SpecificStateA());
	}
}

//当前实例对象的状态
class ContextState{
	private State state;

	public ContextState(State state){
		this.setState(state);
	}

	public void setState(State state) {
		this.state = state;
	}

	public void reauest(){
		state.handle(this);
	}
}
