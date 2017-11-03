/**
 * �н���ģʽ
 * ��һ���н��������װһϵ�еĶ��󽻻���
 * �н���ʹ��������Ҫ��ʾ���໥���ã�
 * �Ӷ�����������ԣ����ҿ��Զ����ظı�����֮��Ľ�����
 *
 */

package design_mode;

public class MediatorMode {
	//This is a test
	public static void main(String[] args) {
		//�н��Ŷ���
		SpecificMediator mediator=new SpecificMediator();
		//ͬ�¶���
		SpecificColleagueA colleagueA=new SpecificColleagueA(mediator);
		SpecificColleagueB colleagueB=new SpecificColleagueB(mediator);

		//ͬ�����н��߽�������
		mediator.setColleague(colleagueA);
		mediator.setColleague(colleagueB);

		//������Ϣ
		colleagueA.send("����ѧ����ʲô��");
		colleagueB.send("ѧ�������ģʽ֮�н���ģʽ��");
		colleagueA.send("�£����ܸ��ҽ�����");
		colleagueB.send("�����ھͿ�ʼ�ɡ�");
	}
}

//�����н�����
abstract class Mediator{
	//��ָ��ͬ���෢����Ϣ
	public abstract void send(String message,Colleague colleague);
}

//�����н�����
class SpecificMediator extends Mediator{
	//����ͬ�������A,B
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

//����ͬ����
abstract class Colleague{
	//ͬ������Ҫ���ս��߶���
	protected Mediator mediator;

	public Colleague(Mediator mediator){
		this.mediator=mediator;
	}
}

//����ͬ����A
class SpecificColleagueA extends Colleague{
	public SpecificColleagueA(Mediator mediator) {
		super(mediator);
	}

	//������Ϣ
	public void send(String message){
		mediator.send(message,this);
	}

	//��ʾ��Ϣ
	public void show(String message){
		System.out.println(ObjectSimplify.getObjectId(this)+":\n��Ϣ->"+message);
	}
}

//����ͬ����B
class SpecificColleagueB extends Colleague{
	public SpecificColleagueB(Mediator mediator) {
		super(mediator);
	}

	//������Ϣ
	public void send(String message){
		mediator.send(message,this);
	}

	//��ʾ��Ϣ
	public void show(String message){
		System.out.println(ObjectSimplify.getObjectId(this)+":\n��Ϣ->"+message);
	}
}