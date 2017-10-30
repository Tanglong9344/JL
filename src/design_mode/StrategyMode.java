/**
 * ����ģʽ��װ�˱仯
 * ����ģʽ������һϵ���㷨������ÿ���㷨��װ������
 * ʹ���ǿ����໥�滻 ���㷨�ı仯����Ӱ�쵽ʹ���㷨�Ŀͻ���
 * ��Ҫ���һ���ӿ�(�������)��
 * Ϊһϵ��ʵ�����ṩͳһ�ķ�����
 * ���ʵ����ʵ�ָýӿڣ�
 */

package design_mode;

public class StrategyMode {
	public static void main(String[] args) {
		//�����Ķ���
		Context context=null;
		//ʵ����A
		context=new Context(new SpecificStrategyA());
		context.contextInterface();

		//ʵ����B
		context=new Context(new SpecificStrategyB());
		context.contextInterface();

		//ʵ����C
		context=new Context(new SpecificStrategyC());
		context.contextInterface();
	}
}

//������
abstract class Strategy{
	//���󷽷�
	public abstract void algorithomIntegerface();
}

//ʵ����A
class SpecificStrategyA extends Strategy{
	@Override
	//ʵ�ַ���
	public void algorithomIntegerface() {
		System.out.println("--SpecificStrategyA.");
	}
}

//ʵ����B
class SpecificStrategyB extends Strategy{
	@Override
	//ʵ�ַ���
	public void algorithomIntegerface() {
		System.out.println("--SpecificStrategyB.");
	}
}

//ʵ����C
class SpecificStrategyC extends Strategy{
	@Override
	//ʵ�ַ���
	public void algorithomIntegerface() {
		System.out.println("--SpecificStrategyC.");
	}
}

//��������
class Context{
	private Strategy strategy=null;
	public Context(Strategy strategy){
		this.strategy=strategy;
	}

	//�����Ľӿڣ����ݴ����ʵ���������ö�Ӧ��ʵ�ַ���
	public void contextInterface(){
		strategy.algorithomIntegerface();
	}
}