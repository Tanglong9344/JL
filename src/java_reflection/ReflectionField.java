package java_reflection;

import java.lang.reflect.Field;

/**
 * 通过反射设置类的属性
 *
 * getField和getDeclaredField的区别
 * 这两个方法都是用于获取字段
 * getField 只能获取public的，包括从父类继承来的字段。
 * getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。
 * (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
 */
public class ReflectionField {
	public static void main(String[] args) {
		Hero h =new Hero();
		h.setName("关羽");
		h.age=100;
		//初始值
		System.out.println("name:"+h.getName()+" age:"+h.age);
		try {
			//使用getDeclaredField获取Hero类中名字叫做name的字段
			Field fName= h.getClass().getDeclaredField("name");
			//设置为可访问
			fName.setAccessible(true);
			System.out.println("Hero类中的'name'字段："+fName);

			//修改这个字段的值
			fName.set(h,"关云长");
			//打印被修改后的值
			System.out.println("name:"+h.getName());

			//使用getField获取类Hero的名字叫做age的字段
			Field fAge= h.getClass().getField("age");
			System.out.println("类中的'age'字段："+fAge);
			//修改这个字段的值
			fAge.set(h,108);
			//打印被修改后的值
			System.out.println("age:"+h.age);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}