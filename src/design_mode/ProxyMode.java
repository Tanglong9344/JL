/**
 * 代理模式:为某些对象提供代理对象以实现对特定对象的访问。
 *
 * 1，远程代理：为一个对象在不同的地址空间提供局域代表。
 * 2，虚拟代理：根据需要创建开销很大的对象。
 * 通过这个对象来存放实例化需要很长时间的真是对象。(例如网页的延迟加载)
 * 3，安全代理：用来控制真实对象访问时的权限。
 * 4，智能指引：当调用真实对象时，使用代理处理另外一些事情。
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

//对象接口
interface Subject{
	public void resuest();
}

//实际对象
class RealSubject implements Subject{
	@Override
	public void resuest() {
		System.out.println("实际对象的实际请求。");
	}
}

//代理对象
class Proxysubject implements Subject{
	RealSubject realSubject = null;
	@Override
	public void resuest() {
		if(realSubject==null){
			realSubject=new RealSubject();
		}
		System.out.println("代理对象的代理请求。");
		//调用实际对象的请求
		realSubject.resuest();
	}
}