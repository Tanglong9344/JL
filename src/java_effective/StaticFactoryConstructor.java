package java_effective;

/**
 * 使用静态工厂方法实例化类
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