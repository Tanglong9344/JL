/**
 * ���������ֻ��һ��ʵ��(����ģʽ)
 * �ο�RunTime��
 */

package design_mode;

public class SingleInstance {
	//��̬����ʵ������
	static final SingleInstance singleInstance=new SingleInstance();
	//����ʵ������
	public SingleInstance getSingleInstance(){
		return singleInstance;
	}
	//˽�й��췽��
	private SingleInstance(){}
}