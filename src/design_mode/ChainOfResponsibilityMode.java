/**
 * ְ����ģʽ
 * ʹ��������л��ᴦ�����󣬴Ӷ���������ķ����ߺͽ�����֮�����Ϲ�ϵ��
 * �������������һ�������������������ݸ�����֪����һ����������Ϊֹ��
 * (���ӣ�������������´���)
 * �ŵ㣺
 * �����ߺͷ����߶�û�жԷ�����ȷ��Ϣ�����еĶ����Լ�Ҳ��֪�����Ľṹ��
 * �����ְ�����ɼ򻯶�����໥���ӣ����ǽ��豣��һ��ֽ�������ߵ����ã�
 * ������Ҫ���������еĺ�ѡ�����ߵ����á�
 * ��󽵵�����϶ȡ�
 */

package design_mode;

public class ChainOfResponsibilityMode {
	//This is a test
	public static void main(String[] args) {
		//�½�����������
		Handler handlerA=new SpecificHandlerA();
		Handler handlerB=new SpecificHandlerB();
		Handler handlerC=new SpecificHandlerC();
		//��������
		handlerA.setSuccessor(handlerB);
		handlerB.setSuccessor(handlerC);

		//��������
		handlerA.handlerRequest((int)(Math.random()*30));
	}
}

//����������
abstract class Handler{
	protected Handler successor;

	//������һ��������
	public void setSuccessor(Handler successor){
		this.successor=successor;
	}

	public abstract void handlerRequest(int request);
}

//���崦������A
class SpecificHandlerA extends Handler{
	@Override
	public void handlerRequest(int request) {
		if(request>=0 && request<10){
			System.out.println(this+"��������"+request);
		}else if(successor!=null){
			successor.handlerRequest(request);
		}
	}
}

//���崦������B
class SpecificHandlerB extends Handler{
	@Override
	public void handlerRequest(int request) {
		if(request>=10 && request<20){
			System.out.println(this+"��������"+request);
		}else if(successor!=null){
			successor.handlerRequest(request);
		}
	}
}

//���崦������C
class SpecificHandlerC extends Handler{
	@Override
	public void handlerRequest(int request) {
		if(request>=20 && request<30){
			System.out.println(this+"��������"+request);
		}else if(successor!=null){
			successor.handlerRequest(request);
		}
	}
}