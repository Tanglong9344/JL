/**
 * ������ģʽ
 * ��ʾһ��������ĳ����ṹ�и�Ԫ�صĲ�����
 * �����ڲ��ı��Ԫ�����ǰ���¶�����������ЩԪ�ص��²�����
 *
 * ������ģʽ���������ݽṹ����ȶ���ϵͳ(�����Ա�)
 */

package design_mode;

import java.util.ArrayList;
import java.util.List;

public class VisitorMode {
	//This is a test
	public static void main(String[] args) {
		//Ԫ�ع������
		ElementManager manager=new ElementManager();
		//���Ԫ��
		manager.add(new SpecificElementA());
		manager.add(new SpecificElementB());

		//�����߶���
		SpecificVisitorA visitorA=new SpecificVisitorA();
		SpecificVisitorB visitorB=new SpecificVisitorB();

		//����
		manager.accept(visitorA);
		manager.accept(visitorB);

	}
}

//�����������
abstract class Visitor{
	//���ʷ���
	public abstract void visitSpecificElementA(SpecificElementA elementA);
	public abstract void visitSpecificElementB(SpecificElementB elementB);
}

//�����������A
class SpecificVisitorA extends Visitor{
	@Override
	public void visitSpecificElementA(SpecificElementA elementA) {
		System.out.println(ObjectSimplify.getObjectId(elementA)+"��"+ObjectSimplify.getObjectId(this)+"����");
	}

	@Override
	public void visitSpecificElementB(SpecificElementB elementB) {
		System.out.println(ObjectSimplify.getObjectId(elementB)+"��"+ObjectSimplify.getObjectId(this)+"����");
	}
}

//�����������B
class SpecificVisitorB extends Visitor{
	@Override
	public void visitSpecificElementA(SpecificElementA elementA) {
		System.out.println(ObjectSimplify.getObjectId(elementA)+"��"+ObjectSimplify.getObjectId(this)+"����");
	}

	@Override
	public void visitSpecificElementB(SpecificElementB elementB) {
		System.out.println(ObjectSimplify.getObjectId(elementB)+"��"+ObjectSimplify.getObjectId(this)+"����");
	}
}

//����Ԫ����
abstract class Element{
	public abstract void accept(Visitor visitor);
}

//����Ԫ����A
class SpecificElementA extends Element{
	@Override
	public void accept(Visitor visitor) {
		visitor.visitSpecificElementA(this);
	}
}

//����Ԫ����B
class SpecificElementB extends Element{
	@Override
	public void accept(Visitor visitor) {
		visitor.visitSpecificElementB(this);
	}
}

//Ԫ�ع�����
class ElementManager{
	List<Element> elements=new ArrayList<Element>();

	//���
	public void add(Element e){
		elements.add(e);
	}

	//�Ƴ�
	public void remove(Element e){
		elements.remove(e);
	}

	//����
	public void accept(Visitor visitor){
		elements.forEach(e->e.accept(visitor));
	}
}