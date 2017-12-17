package design_mode;

/**
 * 备忘录模式
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，
 * 并在该对象之外保存这个状态。这样以后就可将该对
 * 象恢复到保存之前的状态。
 *
 * @author 唐龙
 *
 */
public class MementoMode {
	//This is a test
	public static void main(String[] args) {
		Originator originator=new Originator();
		//初始状态
		originator.setState("状态A");
		originator.show();

		//保存状态
		Caretsker caretaker=new Caretsker();
		caretaker.setMemento(originator.createMemento());

		//状态改变
		originator.setState("状态B");
		originator.show();

		//状态恢复
		originator.setState(caretaker.getMemento().getState());
		originator.show();

	}
}

//发起人类
class Originator{
	private String state;

	public Memento createMemento(){
		return new Memento(state);
	}

	public void setMemento(Memento memento){
		state=memento.getState();
	}
	//显示当前数据状态
	public void show(){
		System.out.println("当前state："+state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

//备忘录类
class Memento{
	private String state;

	public Memento(String state){
		this.state=state;
	}

	public String getState() {
		return state;
	}
}

//管理类
class Caretsker{
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}