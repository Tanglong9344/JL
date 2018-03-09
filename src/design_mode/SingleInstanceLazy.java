package design_mode;

/**
 * 单例模式:通过隐藏构造方法实现(懒汉模式，延迟加载)
 * 缺点，非线程安全
 *
 * @author 唐龙
 */
public class SingleInstanceLazy {
	//静态常量实例对象
	private static SingleInstanceLazy instance = null;
	//返回实例对象
	public static SingleInstanceLazy getInstance(){
		if(instance == null){
			instance = new SingleInstanceLazy();
		}
		return instance;
	}
	//私有构造方法
	private SingleInstanceLazy(){
		System.out.println("单例模式");
	}
}