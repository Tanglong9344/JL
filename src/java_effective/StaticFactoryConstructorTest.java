package java_effective;

/**
 * 静态工厂方法实例化类的测试类
 * @author 唐龙
 */
public class StaticFactoryConstructorTest {
	public static void main(String[] args) {
		//静态方法实例化对象
		StaticFactoryConstructor sfc = StaticFactoryConstructor.newInstance();
		sfc.bye();
	}
}