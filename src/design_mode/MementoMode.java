package design_mode;

/**
 * ����¼ģʽ
 * �ڲ��ƻ���װ�Ե�ǰ���£�����һ��������ڲ�״̬��
 * ���ڸö���֮�Ᵽ�����״̬�������Ժ�Ϳɽ��ö�
 * ��ָ�������֮ǰ��״̬��
 *
 * @author ����
 *
 */
public class MementoMode {
	//This is a test
	public static void main(String[] args) {
		Originator originator=new Originator();
		//��ʼ״̬
		originator.setState("״̬A");
		originator.show();

		//����״̬
		Caretsker caretaker=new Caretsker();
		caretaker.setMemento(originator.createMemento());

		//״̬�ı�
		originator.setState("״̬B");
		originator.show();

		//״̬�ָ�
		originator.setState(caretaker.getMemento().getState());
		originator.show();

	}
}

//��������
class Originator{
	private String state;

	public Memento createMemento(){
		return new Memento(state);
	}

	public void setMemento(Memento memento){
		state=memento.getState();
	}
	//��ʾ��ǰ����״̬
	public void show(){
		System.out.println("��ǰstate��"+state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

//����¼��
class Memento{
	private String state;

	public Memento(String state){
		this.state=state;
	}

	public String getState() {
		return state;
	}
}

//������
class Caretsker{
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}