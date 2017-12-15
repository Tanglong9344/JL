package design_mode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式测试
 * @author 唐龙
 */
public class SingleInstanceTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/**静态实现*/
		SingleInstance ste1 = SingleInstance.getInstance();

		/**安全测试*/
		// 反射获取构造器
		Constructor<SingleInstance> cls = SingleInstance.class.getDeclaredConstructor();
		// 设为可见
		cls.setAccessible(true);
		//实例化
		SingleInstance ste2 = cls.newInstance();

		//相等判断
		System.out.println(ste1.equals(ste2));

		/**enum实现*/
		SingleInstanceEnum.getInstance();
		/**安全测试*/
		// 反射获取构造器
		Constructor<SingleInstanceEnum> clsEnum = SingleInstanceEnum.class.getDeclaredConstructor();
		// 设为可见
		clsEnum.setAccessible(true);
		//实例化，禁止实例化
		//clsEnum.newInstance();
	}
}