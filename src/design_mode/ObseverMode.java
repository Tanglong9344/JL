package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式(发布-订阅模式)
 * 观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一通知对象。
 * 当这个通知对象的状态发生变化时，会通知所有观察者对象，使他们能够自动更新。
 *
 * @author 唐龙
 *
 */
public class ObseverMode {
	public static void main(String[] args) {
		SpecificInform specificInform = new SpecificInform();
		//添加观察者
		specificInform.attach(new SpecificObserver("AAA",specificInform));
		specificInform.attach(new SpecificObserver("BBB",specificInform));
		specificInform.attach(new SpecificObserver("CCC",specificInform));
		//状态变化
		specificInform.setStatus("新通知");
		//通知所有观察者
		specificInform.inform();
	}
}

//抽象通知类
abstract class Inform{
	private List<Observer> observers = new ArrayList<Observer>();
	//添加
	public void attach(Observer observer){
		observers.add(observer);
	}
	//移除
	public void remove(Observer observer){
		observers.remove(observer);
	}
	//通知所有观察者
	public void inform(){
		observers.forEach(o->o.update());
	}
}

//具体通知者类
class SpecificInform extends Inform{
	private String status;//被观察者状态

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

//抽象观察者类
interface Observer{
	public void update();
}

//具体观察者类
class SpecificObserver implements Observer{
	private String name;
	private String status = null;
	private SpecificInform specificInform;

	public SpecificObserver(String name,SpecificInform specificInform){
		this.specificInform=specificInform;
		this.name=name;
	}
	@Override
	public void update() {
		status=specificInform.getStatus();
		System.out.printf("观察者%s的新状态是:%s%n",name,status);
	}
}