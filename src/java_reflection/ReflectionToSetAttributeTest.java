/**
 * 通过反射设置类的属性
 * 
 * getField和getDeclaredField的区别
 * 这两个方法都是用于获取字段
 * getField 只能获取public的，包括从父类继承来的字段。
 * getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。 
 * (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
 */

package java_reflection;

import java.lang.reflect.Field;

public class ReflectionToSetAttributeTest {
	public static void main(String[] args) {
		Hero h =new Hero();
		//使用传统方式修改name的值为gareen
		h.name = "汉献帝";
		//初始值
		System.out.println("name1:"+h.name);
		try {
			//使用getDeclaredField获取类Hero的名字叫做name的字段
			Field f1= h.getClass().getDeclaredField("name");
			System.out.println("类中的'name'字段："+f1);
			//修改这个字段的值
			f1.set(h, "曹操");
			//打印被修改后的值
			System.out.println("name2:"+h.name);

			//使用getField获取类Hero的名字叫做name的字段
			Field f2= h.getClass().getField("name");
			System.out.println("类中的'name'字段："+f2);
			//修改这个字段的值
			f2.set(h, "曹丕");
			//打印被修改后的值
			System.out.println("name3:"+h.name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}