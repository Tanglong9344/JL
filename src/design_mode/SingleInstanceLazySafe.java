package design_mode;

/**
 * 单例模式:通过隐藏构造方法实现(懒汉模式，延迟加载+线程安全)
 * 1.使用 volatile 关键字实现1)可见性和2)禁止指令重排序优化
 * 2.使用synchronized关键字实现同步限制
 * 3.双重null检查提高性能+同步控制
 * @author 唐龙
 */
public class SingleInstanceLazySafe {
	//静态常量实例对象
	private static volatile SingleInstanceLazySafe instance = null;
	//返回实例对象
	public static SingleInstanceLazySafe getInstance(){
		if(instance == null){
			synchronized(SingleInstanceLazySafe.class){
				if(instance == null){
					instance = new SingleInstanceLazySafe();
				}
			}
		}
		return instance;
	}
	//私有构造方法
	private SingleInstanceLazySafe(){
		System.out.println("单例模式");
	}
}