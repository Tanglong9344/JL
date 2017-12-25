package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * �۲���ģʽ(����-����ģʽ)
 * �۲���ģʽ������һ��һ�Զ��������ϵ���ö���۲��߶���ͬʱ����ĳһ֪ͨ����
 * �����֪ͨ�����״̬�����仯ʱ����֪ͨ���й۲��߶���ʹ�����ܹ��Զ����¡�
 *
 * @author ����
 *
 */
public class ObseverMode {
	public static void main(String[] args) {
		SpecificInform specificInform = new SpecificInform();
		//��ӹ۲���
		specificInform.attach(new SpecificObserver("AAA",specificInform));
		specificInform.attach(new SpecificObserver("BBB",specificInform));
		specificInform.attach(new SpecificObserver("CCC",specificInform));
		//״̬�仯
		specificInform.setStatus("��֪ͨ");
		//֪ͨ���й۲���
		specificInform.inform();
	}
}

//����֪ͨ��
abstract class Inform{
	private List<Observer> observers = new ArrayList<Observer>();
	//���
	public void attach(Observer observer){
		observers.add(observer);
	}
	//�Ƴ�
	public void remove(Observer observer){
		observers.remove(observer);
	}
	//֪ͨ���й۲���
	public void inform(){
		observers.forEach(o->o.update());
	}
}

//����֪ͨ����
class SpecificInform extends Inform{
	private String status;//���۲���״̬

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

//����۲�����
interface Observer{
	public void update();
}

//����۲�����
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
		System.out.printf("�۲���%s����״̬��:%s%n",name,status);
	}
}