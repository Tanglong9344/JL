package java_instropector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class IntrospectorTest {
	private String name;
	private int age = 18;

	public static void main(String[] args) throws Exception {
		IntrospectorTest test = new IntrospectorTest();
		test.setName("Caocao");
		test.setAge(22);
		// 如果不想把父类的属性也列出来的话，
		// 那 getBeanInfo 的第二个参数填写父类的信息
		// BeanInfo bi = Introspector.getBeanInfo(test.getClass(), Object.class);
		// 显示类中所有的信息
		BeanInfo bi = Introspector.getBeanInfo(test.getClass());
		System.out.println("BeanInfo:" + bi);
		PropertyDescriptor[] props = bi.getPropertyDescriptors();
		for (int i = 0; i < props.length; i++) {
			System.out.println(props[i].getName() + "=" + props[i].getReadMethod().invoke(test));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}