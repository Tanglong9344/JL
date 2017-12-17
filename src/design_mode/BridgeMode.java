package design_mode;

/**
 * �Ž�ģʽ
 * �����󲿷ֺ�����ʵ�ֲ��ַ��룬ʹ�����ǿ��Զ����ı仯��
 *
 * ʵ��ϵͳ���ܶ�Ƕȷ��࣬ÿһ�ַ��඼�п��ܱ仯��
 * ��ô�Ͱ����ֶ�Ƕȷ�����������Ƕ����仯����������֮�����ϡ�
 *
 * @author ����
 *
 */
public class BridgeMode {
	//This is a test
	public static void main(String[] args) {
		//���������
		Abstraction abstraction=new Abstraction();
		//����ʵ����A
		abstraction.setImplementor(new SpecificImplementorA());
		abstraction.operation();

		//����ʵ����B
		abstraction.setImplementor(new SpecificImplementorB());
		abstraction.operation();
	}
}

//����ʵ����
abstract class Implementor{
	public abstract void operation();
}

//����ʵ����A
class SpecificImplementorA extends Implementor{
	@Override
	public void operation() {
		System.out.println("����ʵ��A��ִ�з�����");
	}
}

//����ʵ����B
class SpecificImplementorB extends Implementor{
	@Override
	public void operation() {
		System.out.println("����ʵ��B��ִ�з�����");
	}
}

//������
class Abstraction{
	protected Implementor implementor;
	public void setImplementor(Implementor implementor){
		this.implementor=implementor;
	}

	public void operation(){
		implementor.operation();
	}
}