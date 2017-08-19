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
		//��spring.txt�л�ȡ�����ƺͷ�������
		File springConfigFile = new File("d:\\MyWorkplace\\JavaBasic\\src\\spring.txt");
		/*���ݶ�ȡ����*/
		System.out.println("-----���ݶ�ȡ����-------");
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
		System.out.println("-----���ݶ�ȡ����-------");
		/*���ݶ�ȡ����*/
		Properties springConfig= new Properties();
		springConfig.load(new FileInputStream(springConfigFile));
		String className = (String) springConfig.get("class");
		String methodName = (String) springConfig.get("method");

		System.out.println("className:"+className);
		System.out.println("methodName:"+methodName);
		//���������ƴ��������
		Class clazz = Class.forName(className);
		System.out.println("���������:"+clazz);
		//���ݷ������ƣ���ȡ����
		Method m = clazz.getMethod(methodName);
		System.out.println("����󷽷���:"+m);
		//��ȡ������
		Constructor c = clazz.getConstructor();
		System.out.println("�������������:"+c);
		//���ݹ�������ʵ����������
		Object service = c.newInstance();
		System.out.println("ʵ������������:"+service);
		//���ö����ָ������
		m.invoke(service);
	}
}
