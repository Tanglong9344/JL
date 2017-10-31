/**
 * װ��ģʽ
 * ��̬�ظ�һ���������һЩ����Ĺ���
 * ��Ч�Ľ���ĺ��Ĺ��ܺ�װ�ι��ܷ���
 * ��װ�ι��ܷ��ڵ��������У�������Ҫ���ж�̬װ�Ρ�
 */

package design_mode;

public class DecorateMode {
	//This is a test
	public static void main(String[] args) {
		SpecificComponent specificComponent = new SpecificComponent();//���ʵ����
		SpecificDecoratorA specificDecoratorA = new SpecificDecoratorA();//װ��ʵ����A
		SpecificDecoratorB specificDecoratorB = new SpecificDecoratorB();//װ��ʵ����B

		//װ�������
		specificDecoratorA.setCompoent(specificComponent);
		specificDecoratorB.setCompoent(specificDecoratorA);
		specificDecoratorB.Operation();
	}
}

//����ӿ�
interface Component{
	public void Operation();
}

//���ʵ����
class SpecificComponent implements Component{
	@Override
	public void Operation() {
		System.out.println("���ʵ���ࡣ");
	}

}

//����װ����
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

//����װ����A
class SpecificDecoratorA extends Decorator{
	@SuppressWarnings("unused")
	private String status;//��A���е����ԣ�����������ʵ����
	@Override
	//��ִ�и����Operation()��ִ�б���Ĳ���
	//�൱�ڶ�ԭ����Component������װ��
	public void Operation(){
		super.Operation();
		status="New Status.";
		System.out.println("����װ����A��");
	}
}

//����װ����B
class SpecificDecoratorB extends Decorator{
	@Override
	public void Operation(){
		super.Operation();
		addBehavior();
		System.out.println("����װ����B��");
	}

	//��B���еķ���������������ʵ����
	private void addBehavior(){}
}