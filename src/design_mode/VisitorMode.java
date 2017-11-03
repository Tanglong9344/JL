/**
 * 访问者模式
 * 表示一个作用于某对象结构中各元素的操作。
 * 可以在不改变各元素类的前提下定义作用于这些元素的新操作。
 *
 * 访问者模式适用于数据结构相对稳定的系统(例如性别)
 */

package design_mode;

import java.util.ArrayList;
import java.util.List;

public class VisitorMode {
	//This is a test
	public static void main(String[] args) {
		//元素管理对象
		ElementManager manager=new ElementManager();
		//添加元素
		manager.add(new SpecificElementA());
		manager.add(new SpecificElementB());

		//访问者对象
		SpecificVisitorA visitorA=new SpecificVisitorA();
		SpecificVisitorB visitorB=new SpecificVisitorB();

		//访问
		manager.accept(visitorA);
		manager.accept(visitorB);

	}
}

//抽象访问者类
abstract class Visitor{
	//访问方法
	public abstract void visitSpecificElementA(SpecificElementA elementA);
	public abstract void visitSpecificElementB(SpecificElementB elementB);
}

//具体访问者类A
class SpecificVisitorA extends Visitor{
	@Override
	public void visitSpecificElementA(SpecificElementA elementA) {
		System.out.println(ObjectSimplify.getObjectId(elementA)+"被"+ObjectSimplify.getObjectId(this)+"访问");
	}

	@Override
	public void visitSpecificElementB(SpecificElementB elementB) {
		System.out.println(ObjectSimplify.getObjectId(elementB)+"被"+ObjectSimplify.getObjectId(this)+"访问");
	}
}

//具体访问者类B
class SpecificVisitorB extends Visitor{
	@Override
	public void visitSpecificElementA(SpecificElementA elementA) {
		System.out.println(ObjectSimplify.getObjectId(elementA)+"被"+ObjectSimplify.getObjectId(this)+"访问");
	}

	@Override
	public void visitSpecificElementB(SpecificElementB elementB) {
		System.out.println(ObjectSimplify.getObjectId(elementB)+"被"+ObjectSimplify.getObjectId(this)+"访问");
	}
}

//抽象元素类
abstract class Element{
	public abstract void accept(Visitor visitor);
}

//具体元素类A
class SpecificElementA extends Element{
	@Override
	public void accept(Visitor visitor) {
		visitor.visitSpecificElementA(this);
	}
}

//具体元素类B
class SpecificElementB extends Element{
	@Override
	public void accept(Visitor visitor) {
		visitor.visitSpecificElementB(this);
	}
}

//元素管理类
class ElementManager{
	List<Element> elements=new ArrayList<Element>();

	//添加
	public void add(Element e){
		elements.add(e);
	}

	//移除
	public void remove(Element e){
		elements.remove(e);
	}

	//访问
	public void accept(Visitor visitor){
		elements.forEach(e->e.accept(visitor));
	}
}