/**
 * ������ģʽ(��Ҫ�Ƕ���������ģʽ)
 * ��һ����Ľӿ�ת���ɿͻ�ϣ��������һ���ӿ�
 * ʹ��ԭ�����ڽӿڲ����ݶ��޷�һ�����������һ����
 *
 * ��ϵͳ�����ݺ���Ϊ����ȷ���ӿڲ���ʱ��ʹ��������ʹ�ÿ��Ʒ�Χ֮��
 * ��һ��ԭ�ж�����ĳ���ӿ�ƥ�䡣
 */

package design_mode;

public class AdapterMode {
	//This is a test
	public static void main(String[] args) {
		Target target = new Adapter();
		target.request();

	}
}

//������
class Target{
	public void request(){
		System.out.println("�����෢��������");
	}
}

//��Ҫ�������
class AdapterClass{
	public void request(){
		System.out.println("������ʵ������");
	}
}

//������
class Adapter extends Target{
	private AdapterClass adapterClass=new AdapterClass();

	@Override
	public void request(){
		super.request();
		//��Target�����󷽷�ͨ��Adapterת��ΪAdapterClass�����󷽷�(����)
		adapterClass.request();
	}
}