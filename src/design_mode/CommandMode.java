package design_mode;

/**
 * ����ģʽ
 * ��һ�������װΪ���󣬴Ӷ�������ò�ͬ������Կͻ����в�������
 * �������Ŷӻ��¼������־�Լ�֧�ֿɳ����Ĳ�����
 *
 * �ŵ㣺
 * 1���Ƚ����׵����һ���������
 * 2������Ҫ������£����Խ����׵ؽ����������־
 * 3��������������һ�������Ƿ�Ҫ�������
 * 4���������׵�ʵ�ֶ�����ĳ���������
 * 5������������������Ӱ���������࣬����������������������ס�
 * 6��������һ�������Ķ�����֪����ôִ��һ�������Ķ���ָ��
 *
 * @author ����
 *
 */
public class CommandMode {
	//This is a test
	public static void main(String[] args) {
		//���������
		Receiver receiver=new Receiver("��������");
		//��������
		Command command=new SpecificCommand(receiver);
		Invoker invoker=new Invoker();
		invoker.setCommand(command);
		invoker.executeCommand();
	}
}

//�����������
class Receiver{
	private String command;
	//��������
	public Receiver(String command){
		this.command=command;
	}
	//����
	public void Action(){
		System.out.println("���"+command);
	}
}

//����ִ������
class Invoker{
	private Command command;
	//��ȡ����
	public void setCommand(Command command){
		this.command=command;
	}
	//ִ������
	public void executeCommand(){
		command.execute();
	}
}

//����������
abstract class Command{
	protected Receiver receiver;

	public Command(Receiver receiver){
		this.receiver=receiver;
	}

	//����ִ��
	abstract public void execute();
}

//����������
class SpecificCommand extends Command{
	public SpecificCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.Action();
	}
}