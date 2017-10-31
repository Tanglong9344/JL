/**
 * ����ģʽ:ΪĳЩ�����ṩ���������ʵ�ֶ��ض�����ķ��ʡ�
 *
 * 1��Զ�̴���Ϊһ�������ڲ�ͬ�ĵ�ַ�ռ��ṩ�������
 * 2���������������Ҫ���������ܴ�Ķ���
 * ͨ��������������ʵ������Ҫ�ܳ�ʱ������Ƕ���(������ҳ���ӳټ���)
 * 3����ȫ��������������ʵ�������ʱ��Ȩ�ޡ�
 * 4������ָ������������ʵ����ʱ��ʹ�ô���������һЩ���顣
 */

package design_mode;

public class ProxyMode {
	//This is a test
	public static void main(String[] args) {
		Proxysubject proxysubject = new Proxysubject();
		proxysubject.realSubject = new RealSubject();
		proxysubject.resuest();
	}
}

//����ӿ�
interface Subject{
	public void resuest();
}

//ʵ�ʶ���
class RealSubject implements Subject{
	@Override
	public void resuest() {
		System.out.println("ʵ�ʶ����ʵ������");
	}
}

//�������
class Proxysubject implements Subject{
	RealSubject realSubject = null;
	@Override
	public void resuest() {
		if(realSubject==null){
			realSubject=new RealSubject();
		}
		System.out.println("�������Ĵ�������");
		//����ʵ�ʶ��������
		realSubject.resuest();
	}
}