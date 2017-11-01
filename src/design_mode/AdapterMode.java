/**
 * 适配器模式(主要是对象适配器模式)
 * 讲一个类的接口转换成客户希望的另外一个接口
 * 使得原来由于接口不兼容而无法一起工作的类可以一起工作
 *
 * 当系统的数据和行为都正确但接口不符时，使用适配器使得控制范围之外
 * 的一个原有对象与某个接口匹配。
 */

package design_mode;

public class AdapterMode {
	//This is a test
	public static void main(String[] args) {
		Target target = new Adapter();
		target.request();

	}
}

//期望类
class Target{
	public void request(){
		System.out.println("期望类发出的请求。");
	}
}

//需要适配的类
class AdapterClass{
	public void request(){
		System.out.println("适配后的实际请求。");
	}
}

//适配器
class Adapter extends Target{
	private AdapterClass adapterClass=new AdapterClass();

	@Override
	public void request(){
		super.request();
		//将Target的请求方法通过Adapter转换为AdapterClass的请求方法(适配)
		adapterClass.request();
	}
}