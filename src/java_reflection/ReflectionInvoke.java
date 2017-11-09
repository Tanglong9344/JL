package java_reflection;

import java.lang.reflect.Method;

/**
 * 通过反射调用方法
 * @author 唐龙
 */
public class ReflectionInvoke {
	public static void main(String[] args) {
		Hero h = new Hero("关羽");
		//一般调用方法
		h.setName("关云长");
		System.out.println("一般调用方法：" + h.getName());
		try {
			// 获取这个类的名字叫做setName，参数类型是String的方法
			Method ms = h.getClass().getMethod("setName", String.class);
			//对h对象调用方法
			ms.invoke(h,"关大刀");
			ms = h.getClass().getMethod("getName");
			System.out.println("利用反射调用方法：" + ms.invoke(h));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}