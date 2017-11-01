/**
 * ״̬ģʽ
 * ��һ�����������״̬�仯ʱ����ı�����Ϊ
 * ��������������Ǹı�������
 *
 * ״̬ģʽ��Ҫ������ǵ�����һ������ת�����������ʽ���븴��ʱ�������
 * ��״̬���ж��߼�ת�Ƶ���ʾ��ͬ״̬��һϵ���൱�У����԰ɸ��ӵ��ж��߼��򻯡�
 *
 * ״̬ģʽ�ĺô��ǽ����ض�״̬��ص���Ϊ�ֲ��������ҽ���ͬ״̬����Ϊ�ָ��(�����ڲ�ͬ����)
 * ���ó�������һ���������Ϊȡ��������״̬���ұ���������ʱ�̸��ݾ���״̬�ı�������Ϊʱ��
 */

package design_mode;

public class StateMode {
	//This is a test
	public static void main(String[] args) {
		//��ʼ״̬ΪA
		ContextState ContextState=new ContextState(new SpecificStateA());
		//���ϸ���״̬
		ContextState.reauest();
		ContextState.reauest();
		ContextState.reauest();
	}
}

//����״̬ת����
abstract class State{
	public abstract void handle(ContextState ContextState);
}

//����״̬ת����A
class SpecificStateA extends State{
	@Override
	public void handle(ContextState ContextState) {
		//������һ��״̬��B
		ContextState.setState(new SpecificStateB());
	}
}

//����״̬ת����B
class SpecificStateB extends State{
	@Override
	public void handle(ContextState ContextState) {
		//������һ��״̬��A
		ContextState.setState(new SpecificStateA());
	}
}

//��ǰʵ�������״̬
class ContextState{
	private State state;

	public ContextState(State state){
		this.setState(state);
	}

	public void setState(State state) {
		System.out.println("��ǰ״̬"+state);
		this.state = state;
	}

	public void reauest(){
		state.handle(this);
	}
}
