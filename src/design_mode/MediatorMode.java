/**
 * 中介者模式
 * 用一个中介对象来封装一系列的对象交互。
 * 中介者使各对象不需要显示地相互引用，
 * 从而降低其耦合性，而且可以独立地改变它们之间的交互。
 *
 */

package design_mode;

public class MediatorMode {
	//This is a test
	public static void main(String[] args) {
		//中介着对象
		SpecificMediator mediator=new SpecificMediator();
		//同事对象
		SpecificColleagueA colleagueA=new SpecificColleagueA(mediator);
		SpecificColleagueB colleagueB=new SpecificColleagueB(mediator);

		//同事与中介者建立连接
		mediator.setColleague(colleagueA);
		mediator.setColleague(colleagueB);

		//发送消息
		colleagueA.send("今天学的是什么？");
		colleagueB.send("学的是设计模式之中介者模式。");
		colleagueA.send("奥，你能给我讲讲吗？");
		colleagueB.send("那现在就开始吧。");
	}
}

//抽象中介者类
abstract class Mediator{
	//向指定同事类发送消息
	public abstract void send(String message,Colleague colleague);
}

//具体中介者类
class SpecificMediator extends Mediator{
	//定义同事类对象A,B
	private SpecificColleagueA colleagueA;
	private SpecificColleagueB colleagueB;
	public void setColleague(SpecificColleagueA colleagueA) {
		this.colleagueA = colleagueA;
	}
	public void setColleague(SpecificColleagueB colleagueB) {
		this.colleagueB = colleagueB;
	}
	@Override
	public void send(String message, Colleague colleague) {
		if(colleague==colleagueA){
			colleagueB.show(message);
		}else{
			colleagueA.show(message);
		}
	}
}

//抽象同事类
abstract class Colleague{
	//同事类需要的终结者对象
	protected Mediator mediator;

	public Colleague(Mediator mediator){
		this.mediator=mediator;
	}
}

//具体同事类A
class SpecificColleagueA extends Colleague{
	public SpecificColleagueA(Mediator mediator) {
		super(mediator);
	}

	//发送信息
	public void send(String message){
		mediator.send(message,this);
	}

	//显示信息
	public void show(String message){
		System.out.println(ObjectSimplify.getObjectId(this)+":\n信息->"+message);
	}
}

//具体同事类B
class SpecificColleagueB extends Colleague{
	public SpecificColleagueB(Mediator mediator) {
		super(mediator);
	}

	//发送信息
	public void send(String message){
		mediator.send(message,this);
	}

	//显示信息
	public void show(String message){
		System.out.println(ObjectSimplify.getObjectId(this)+":\n信息->"+message);
	}
}