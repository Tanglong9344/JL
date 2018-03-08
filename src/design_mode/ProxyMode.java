package design_mode;

/**
 * ����ģʽ:ΪĳЩ�����ṩ���������ʵ�ֶ��ض�����ķ��ʡ�
 *
 * 1��Զ�̴���Ϊһ�������ڲ�ͬ�ĵ�ַ�ռ��ṩ�������
 * 2���������������Ҫ���������ܴ�Ķ���
 * ͨ��������������ʵ������Ҫ�ܳ�ʱ������Ƕ���(������ҳ���ӳټ���)
 * 3����ȫ��������������ʵ�������ʱ��Ȩ�ޡ�
 * 4������ָ������������ʵ����ʱ��ʹ�ô���������һЩ���顣
 *
 * @author ����
 *
 */
public class ProxyMode {
	//This is a test
	public static void main(String[] args) {
		Proxysubject proxysubject = new Proxysubject(new RealSubject());
		proxysubject.request();
	}
}

//����ӿ�
interface Subject{
	public void request();
}

//ʵ�ʶ���
class RealSubject implements Subject{
	@Override
	public void request() {
		System.out.println("ʵ�ʶ����ʵ������");
	}
}

/** ������� */
class Proxysubject implements Subject{
	RealSubject realSubject = null;

	public Proxysubject(RealSubject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void request() {
		if(realSubject==null){
			realSubject=new RealSubject();
		}
		System.out.println("�������Ĵ�������");
		//����ʵ�ʶ��������
		realSubject.request();
	}
}