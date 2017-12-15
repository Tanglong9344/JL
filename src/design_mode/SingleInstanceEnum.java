package design_mode;

/**
 * 单例模式：使用枚举实现
 * 优点：
 * 1.线程安全
 * 2.防止反射强行调用构造器
 * 3.提供了自动序列化机制，防止反序列化的时候创建新的对象
 * @author 唐龙
 */
public class SingleInstanceEnum {
	private SingleInstanceEnum(){
		System.out.println("单例模式(enum)");
	}

	public static SingleInstanceEnum getInstance(){
		return Singleton.INSTANCE.getInstance();
	}

	/** 静态内部 enum */
	private static enum Singleton{
		INSTANCE;
		private final SingleInstanceEnum singleton;

		/** 构造方法，JVM会保证此方法绝对只调用一次*/
		private Singleton(){
			singleton = new SingleInstanceEnum();
		}

		/**返回实例*/
		public SingleInstanceEnum getInstance(){
			return singleton;
		}
	}
}