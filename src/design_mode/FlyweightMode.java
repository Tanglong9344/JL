package design_mode;

import java.util.Hashtable;

/**
 * ��Ԫģʽ
 * ���ù�������Ч��֧�ִ���ϸ���ȵĶ���
 *
 * ����Ԫ�����ڲ����Ҳ����滷���ı���ı�Ĺ���������Ԫ������ڲ�״̬
 * ���滷���ı���仯�Ҳ��ɹ����״̬���ⲿ״̬��
 * ��Ԫģʽ���Ա�������ǳ�������Ŀ�����
 * �ڳ�������У���ʱ��Ҫ���ɴ���ϸ���ȵ���ʵ������ʾ���ݡ�
 * ����ܹ�������Щʵ�����˼����������������ֻ�����ͬ
 * ͨ����Щ�����Ƶ���ʵ�������棬�ڷ�������ʱ�����Ǵ��ݽ����ķ�����
 * �Ϳ���ͨ���������ȵؼ���ʵ�������������
 *
 * @author ����
 *
 */
public class FlyweightMode {
	//This is a test
	public static void main(String[] args) {
		//��Ԫ��״̬
		int state=0;
		//��Ԫ�๤��
		FlyweightFactory factory=new FlyweightFactory();
		//��Ԫ��
		Flyweight flyweightA=factory.getFlyweight("A");
		flyweightA.operation(++state);

		//��Ԫ��
		Flyweight flyweightB=factory.getFlyweight("B");
		flyweightB.operation(++state);

		UnsharedSpecificFlyweight unFlyweight=new UnsharedSpecificFlyweight();
		unFlyweight.operation(++state);
	}
}

//������Ԫ��
abstract class Flyweight{
	public abstract void operation(int state);
}

//������Ԫ��
class SpecificFlyweight extends Flyweight{
	@Override
	public void operation(int state) {
		System.out.println("������Ԫ�࣬״̬��"+state);
	}
}

//���岻������Ԫ��
class UnsharedSpecificFlyweight extends Flyweight{
	@Override
	public void operation(int state) {
		System.out.println("�����������Ԫ�࣬״̬��"+state);
	}
}

//��Ԫ�����࣬���������͹�����Ԫ��
class FlyweightFactory{
	private Hashtable<String,Object> flyweights = new Hashtable<String,Object>();

	//��ȡ��Ԫ�����
	public Flyweight getFlyweight(String key){
		if(flyweights.get(key)==null){
			flyweights.put(key,new SpecificFlyweight());
		}
		return (Flyweight)flyweights.get(key);
	}
}