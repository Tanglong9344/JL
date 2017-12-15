package design_mode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式：使用枚举实现测试
 * @author 唐龙
 */
public class SingleInstanceEnumTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingleInstanceEnum ste1 = SingleInstanceEnum.getInstance();

		/**安全测试*/
		// 反射获取构造器
		Constructor<SingleInstanceEnum> cls = SingleInstanceEnum.class.getDeclaredConstructor();
		// 设为可见
		cls.setAccessible(true);
		//实例化
		SingleInstanceEnum ste2 = cls.newInstance();

		System.out.println("---------比较开始-----------");
		//相等判断
		System.out.println(ste1.equals(ste2));
	}
}