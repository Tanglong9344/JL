package design_mode;

/**
 * 命令模式
 * 将一个请求封装为对象，从而是你可用不同的请求对客户进行参数化：
 * 对请求排队或记录请求日志以及支持可撤销的操作。
 *
 * 优点：
 * 1，比较容易地设计一个命令队列
 * 2，在需要的情况下，可以较容易地将命令记入日志
 * 3，允许接收请求的一方决定是否要否决请求
 * 4，可以容易地实现对请求的撤销和重做
 * 5，由于新增具体的命令不影响其它的类，因此新增具体命令类会更容易。
 * 6，将请求一个操作的对象与知道怎么执行一个操作的对象分割开。
 *
 * @author 唐龙
 *
 */
public class CommandMode {
	//This is a test
	public static void main(String[] args) {
		//命令接收器
		Receiver receiver=new Receiver("发起请求。");
		//建立命令
		Command command=new SpecificCommand(receiver);
		Invoker invoker=new Invoker();
		invoker.setCommand(command);
		invoker.executeCommand();
	}
}

//命令接收者类
class Receiver{
	private String command;
	//接收命令
	public Receiver(String command){
		this.command=command;
	}
	//命令
	public void Action(){
		System.out.println("命令："+command);
	}
}

//命令执行者类
class Invoker{
	private Command command;
	//获取命令
	public void setCommand(Command command){
		this.command=command;
	}
	//执行命令
	public void executeCommand(){
		command.execute();
	}
}

//抽象命令类
abstract class Command{
	protected Receiver receiver;

	public Command(Receiver receiver){
		this.receiver=receiver;
	}

	//命令执行
	abstract public void execute();
}

//具体命令类
class SpecificCommand extends Command{
	public SpecificCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.Action();
	}
}