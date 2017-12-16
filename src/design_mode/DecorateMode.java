package design_mode;


/**
 * װ��ģʽ
 * ��̬�ظ�һ���������һЩ����Ĺ���(���Ի��߷���)
 * ��Ч�Ľ���ĺ��Ĺ��ܺ�װ�ι��ܷ���
 * ��װ�ι��ܷ��ڵ��������У�������Ҫ���ж�̬װ�Ρ�
 *
 * @author ����
 */
public class DecorateMode {
	public static void main(String[] args) {
		SpecificComponent sc = new SpecificComponent();//���ʵ����
		SpecificDecoratorA sdA = new SpecificDecoratorA();//װ��ʵ����A
		SpecificDecoratorB sdB = new SpecificDecoratorB();//װ��ʵ����B

		//װ�������
		sdA.setCompoent(sc);
		sdB.setCompoent(sdA);
		sdB.Operation();
	}
}

/**����ӿ�*/
interface Component{
	public void Operation();
}

/**���ʵ����*/
class SpecificComponent implements Component{
	@Override
	public void Operation() {
		System.out.println("���ʵ���ࡣ");
	}

}

/**����װ����*/
abstract class Decorator implements Component{
	protected Component component;
	public void setCompoent(Component component){
		this.component = component;
	}
	@Override
	public void Operation(){
		if(component != null){
			component.Operation();
		}
	}
}

/**����װ����A*/
class SpecificDecoratorA extends Decorator{
	private String status;//��A���е����ԣ�����������ʵ����
	@Override
	//��ִ�и����Operation()��ִ�б���Ĳ���
	//�൱�ڶ�ԭ����Component������װ��
	public void Operation(){
		super.Operation();
		status="New Status.";
		System.out.println("����װ����A," + status);
	}
}

/**��װ����B*/
class SpecificDecoratorB extends Decorator{
	@Override
	public void Operation(){
		super.Operation();
		addBehavior();
		System.out.println("����װ����B...");
	}
	//��B���еķ���������������ʵ����
	private void addBehavior(){}
}