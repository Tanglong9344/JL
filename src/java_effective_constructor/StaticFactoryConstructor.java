package java_effective_constructor;

/**
 * 使用静态工厂方法实例化类
 *
 * 优点
 * 1.可以任意命名
 * 2.可以返回任意子类型
 * 3.使得实例化的代码更加简洁
 * @author 唐龙
 */
public class StaticFactoryConstructor {
	/**私有构造器*/
	private StaticFactoryConstructor(){
		System.out.println("Welcome to Static Factory Constructor...");
	}

	/**静态实例化方法*/
	public static StaticFactoryConstructor newInstance(){
		return new StaticFactoryConstructor();
	}

	/**结束方法*/
	public void bye(){
		System.out.println("See you again...");
	}
}