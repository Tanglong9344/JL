package design_mode;

/**
 * 单例模式:通过隐藏构造方法实现(懒汉模式，延迟加载+线程安全)
 * 1.使用 volatile
 * 2.使用synchronized关键字实现同步限制
 * 3.双重null检查提高性能+同步控制
 *
 * 被volatile修饰的变量
 * 1. 每次被线程访问时，都强迫从共享内存中重读该变量的值。
 * 2. 当变量发生变化时，强迫线程将变化值回写到共享内存。
 * 3. volatile屏蔽掉了VM中必要的代码优化，所以在效率上比较低，因此一定在必要时才使用此关键字。
 *
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