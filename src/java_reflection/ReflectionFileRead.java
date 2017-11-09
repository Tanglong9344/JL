package java_reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionFileRead {
	public static void main(String[] args) throws Exception {
		//��config.txt�л�ȡ�����ƺͷ�������
		File config = new File("src/java_reflection/config.txt");
		//���ݶ�ȡ
		FileReader fr = new FileReader(config);
		char[] all = new char[(int)config.length()];
		fr.read(all);
		fr.close();
		System.out.println("-----------�ָ���------------");
		for (char b : all) {
			System.out.print(b);
		}
		System.out.println();
		System.out.println("-----------�ָ���------------");

		//Properties ���Լ�����Ҳ����תΪ��
		Properties configPro= new Properties();
		configPro.load(new FileInputStream(config));
		String className = (String)configPro.get("class");
		String methodName = (String)configPro.get("method");
		//��ʾ�����ͷ�����
		System.out.println("className��"+className);
		System.out.println("methodName��"+methodName);
		//���������ƴ��������
		Class<?> clazz = Class.forName(className);
		System.out.println("�����ƣ�"+clazz);
		//���ݷ������ƣ���ȡ����
		Method m = clazz.getMethod(methodName);
		System.out.println("�෽������"+m);
		//��ȡ���ι��췽��
		Constructor<?> c = clazz.getConstructor(String.class);
		System.out.println("�๹�췽�����ƣ�"+c);
		//���ݹ��췽����ʵ����������
		Object object = c.newInstance("����");
		//�Զ��������toString����
		System.out.println("ʵ�����������ƣ�"+object);
		//���ö����ָ������
		System.out.println("���÷�����"+m.invoke(object));;
	}
}