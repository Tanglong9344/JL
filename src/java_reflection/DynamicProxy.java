package java_reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
	public static void main(String[] args) {
		MethodInterface method = MethodProxyFactory.newInstance(MethodInterface.class);
		method.helloDynamicProxy();
	}
}

/**
 * ����ӿ�
 * ʹ�ö�̬��������Ҫʵ�ֽӿ�
 */
interface MethodInterface {
	String helloDynamicProxy();
}

/**
 * ������
 * ʵ��InvocationHandler�ӿ�
 * �������ô�����
 */
class MethodProxy<T> implements InvocationHandler{
	Class<T> methodInterface;

	public MethodProxy(Class<T> methodInterface) {
		this.methodInterface=methodInterface;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Hello Dynamic Proxy.");
		System.out.println("������:" + method.getName());
		return null;
	}
}

/**
 * ������������
 */
class MethodProxyFactory {
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<T> methodInterface) {
		final MethodProxy<T> methodProxy = new MethodProxy<T>(methodInterface);
		//����ʵ��������
		return (T) Proxy.newProxyInstance(
				methodInterface.getClassLoader(),
				new Class[]{methodInterface},
				methodProxy);
	}
}