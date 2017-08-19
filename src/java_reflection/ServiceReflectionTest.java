package java_reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class ServiceReflectionTest {
	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public static void main(String[] args) throws Exception {
		//从spring.txt中获取类名称和方法名称
		File springConfigFile = new File("d:\\MyWorkplace\\JavaBasic\\src\\spring.txt");
		/*内容读取测试*/
		System.out.println("-----内容读取测试-------");
		FileReader fr = new FileReader(springConfigFile);
		char[] all = new char[(int) springConfigFile.length()];
		fr.read(all);
		for (char b : all) {
			System.out.print(b);
		}
		fr.read(all);
		for (char b : all) {
			System.out.print(b);
		}
		System.out.println();
		System.out.println("-----内容读取测试-------");
		/*内容读取测试*/
		Properties springConfig= new Properties();
		springConfig.load(new FileInputStream(springConfigFile));
		String className = (String) springConfig.get("class");
		String methodName = (String) springConfig.get("method");

		System.out.println("className:"+className);
		System.out.println("methodName:"+methodName);
		//根据类名称创建类对象
		Class clazz = Class.forName(className);
		System.out.println("类对象名称:"+clazz);
		//根据方面名称，获取方法
		Method m = clazz.getMethod(methodName);
		System.out.println("类对象方法名:"+m);
		//获取构造器
		Constructor c = clazz.getConstructor();
		System.out.println("类对象构造器名称:"+c);
		//根据构造器，实例化出对象
		Object service = c.newInstance();
		System.out.println("实例化对象名称:"+service);
		//调用对象的指定方法
		m.invoke(service);
	}
}
