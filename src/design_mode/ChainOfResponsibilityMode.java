/**
 * 职责链模式
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
 * 将这个对象连成一条链并沿着这条链传递该请求，知道有一个对象处理它为止。
 * (例子：物流处理和人事处理)
 * 优点：
 * 接收者和发送者都没有对方的明确信息且链中的对象自己也不知道链的结构。
 * 结果是职责链可简化对象的相互连接，它们仅需保持一个纸箱其后继者的引用，
 * 而不需要保持它所有的候选接收者的引用。
 * 大大降低了耦合度。
 */

package design_mode;

public class ChainOfResponsibilityMode {
	//This is a test
	public static void main(String[] args) {
		//新建处理器对象
		Handler handlerA=new SpecificHandlerA();
		Handler handlerB=new SpecificHandlerB();
		Handler handlerC=new SpecificHandlerC();
		//建立连接
		handlerA.setSuccessor(handlerB);
		handlerB.setSuccessor(handlerC);

		//处理请求
		handlerA.handlerRequest((int)(Math.random()*30));
	}
}

//抽象处理器类
abstract class Handler{
	protected Handler successor;

	//设置下一个处理器
	public void setSuccessor(Handler successor){
		this.successor=successor;
	}

	public abstract void handlerRequest(int request);
}

//具体处理类器A
class SpecificHandlerA extends Handler{
	@Override
	public void handlerRequest(int request) {
		if(request>=0 && request<10){
			System.out.println(this+"处理请求。"+request);
		}else if(successor!=null){
			successor.handlerRequest(request);
		}
	}
}

//具体处理类器B
class SpecificHandlerB extends Handler{
	@Override
	public void handlerRequest(int request) {
		if(request>=10 && request<20){
			System.out.println(this+"处理请求。"+request);
		}else if(successor!=null){
			successor.handlerRequest(request);
		}
	}
}

//具体处理类器C
class SpecificHandlerC extends Handler{
	@Override
	public void handlerRequest(int request) {
		if(request>=20 && request<30){
			System.out.println(this+"处理请求。"+request);
		}else if(successor!=null){
			successor.handlerRequest(request);
		}
	}
}