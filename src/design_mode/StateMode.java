package design_mode;

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
 *
 * @author ����
 *
 */
public class StateMode {
	//This is a test
	public static void main(String[] args) {
		//��ʼ״̬ΪA
		ContextState contextState=new ContextState(new SpecificStateA());
		//���ϸ���״̬(��A,B,C֮�䲻���л�)
		for(int i=0;i<10;i++){
			contextState.reauest();
		}
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
		System.out.println("��ǰ״̬��״̬A");
		//ת������һ��״̬
		ContextState.setState(new SpecificStateB());
	}
}

//����״̬ת����B
class SpecificStateB extends State{
	@Override
	public void handle(ContextState ContextState) {
		System.out.println("��ǰ״̬��״̬B");
		//ת������һ��״̬
		ContextState.setState(new SpecificStateC());
	}
}

//����״̬ת����C
class SpecificStateC extends State{
	@Override
	public void handle(ContextState ContextState) {
		System.out.println("��ǰ״̬��״̬C");
		//ת������һ��״̬
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
		this.state = state;
	}

	public void reauest(){
		state.handle(this);
	}
}
