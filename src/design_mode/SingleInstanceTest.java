package design_mode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式安全测试
 * @author 唐龙
 */
public class SingleInstanceTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//SingleInstance.getSingleInstance();
		//反射获取构造器
		Constructor<SingleInstance> cls = SingleInstance.class.getDeclaredConstructor();
		//设为可见
		cls.setAccessible(true);
		//实例化
		cls.newInstance();
	}
}