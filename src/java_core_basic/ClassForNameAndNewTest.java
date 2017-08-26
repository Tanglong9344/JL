package java_core_basic;

import java_generic.Hero;

public class ClassForNameAndNewTest {
	public static void main(String[] args) {
		//Class.forName();
		try {
			Class<?> clazz = Class.forName("java_generic.Hero");
			System.out.println("Class.forName(\"java_generic.Hero\"):\n "+clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//newInstance()
		try {
			Object obj1 = Class.forName("java_generic.Hero").newInstance();
			System.out.println("Class.forName(\"java_generic.Hero\").newInstance():\n "+obj1);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//new
		Hero obj2 = new Hero();
		System.out.println("new:\n "+obj2);
	}
}
