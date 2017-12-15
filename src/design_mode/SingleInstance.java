package design_mode;

/**
 * 单例模式:通过隐藏构造方法实现(饿汉模式)
 * 一个类仅有一个实例
 * 并提供一个访问它的全局访问点
 * 参看Runtime类
 *
 * 注意：要防止其它程序通过反射机制访问私有构造器<code>SingleInstanceTest</code>
 * 解决方式：使用枚举实现单例模式<code>SingleInstanceEnum.java</code>
 *
 * 单例模式实现注意事项：
 * 1.线程安全
 * 2.延迟加载
 * 3.序列化与反序列化安全
 * @author 唐龙
 */
public class SingleInstance {
	//静态常量实例对象
	private static final SingleInstance INSTANCE = new SingleInstance();
	//返回实例对象
	public static SingleInstance getInstance(){
		return INSTANCE;
	}
	//私有构造方法
	private SingleInstance(){
		System.out.println("单例模式");
	}
}