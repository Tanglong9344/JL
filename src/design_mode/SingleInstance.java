/**
 * 单例模式
 * 一个类仅有一个实例
 * 并提供一个访问它的全局访问点
 *
 * 参看RunTime类
 */

package design_mode;

public class SingleInstance {
	//静态常量实例对象
	private static final SingleInstance singleInstance=new SingleInstance();
	//返回实例对象
	public SingleInstance getSingleInstance(){
		return singleInstance;
	}
	//私有构造方法
	private SingleInstance(){}
}