package java_reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionFileRead {
	public static void main(String[] args) throws Exception {
		//从config.txt中获取类名称和方法名称
		File config = new File("src/java_reflection/config.txt");
		//内容读取
		FileReader fr = new FileReader(config);
		char[] all = new char[(int)config.length()];
		fr.read(all);
		fr.close();
		System.out.println("-----------分割线------------");
		for (char b : all) {
			System.out.print(b);
		}
		System.out.println();
		System.out.println("-----------分割线------------");

		//Properties 可以加载流也可以转为流
		Properties configPro= new Properties();
		configPro.load(new FileInputStream(config));
		String className = (String)configPro.get("class");
		String methodName = (String)configPro.get("method");
		//显示类名和方法名
		System.out.println("className："+className);
		System.out.println("methodName："+methodName);
		//根据类名称创建类对象
		Class<?> clazz = Class.forName(className);
		System.out.println("类名称："+clazz);
		//根据方法名称，获取方法
		Method m = clazz.getMethod(methodName);
		System.out.println("类方法名："+m);
		//获取带参构造方法
		Constructor<?> c = clazz.getConstructor(String.class);
		System.out.println("类构造方法名称："+c);
		//根据构造方法，实例化出对象
		Object object = c.newInstance("唐龙");
		//自动调用类的toString方法
		System.out.println("实例化对象名称："+object);
		//调用对象的指定方法
		System.out.println("调用方法："+m.invoke(object));;
	}
}