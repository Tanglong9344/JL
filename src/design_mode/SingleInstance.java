/**
 * 这个类有且只有一个实例(单例模式)
 * 参看RunTime类
 */

package design_mode;

public class SingleInstance {
	//静态常量实例对象
	static final SingleInstance singleInstance=new SingleInstance();
	//返回实例对象
	public SingleInstance getSingleInstance(){
		return singleInstance;
	}
	//私有构造方法
	private SingleInstance(){}
}