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
 * 代理接口
 * 使用动态代理，不需要实现接口
 */
interface MethodInterface {
	String helloDynamicProxy();
}

/**
 * 代理类
 * 实现InvocationHandler接口
 * 创建调用处理器
 */
class MethodProxy<T> implements InvocationHandler{
	Class<T> methodInterface;

	public MethodProxy(Class<T> methodInterface) {
		this.methodInterface=methodInterface;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Hello Dynamic Proxy.");
		System.out.println("方法名:" + method.getName());
		return null;
	}
}

/**
 * 方法代理工厂类
 */
class MethodProxyFactory {
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<T> methodInterface) {
		final MethodProxy<T> methodProxy = new MethodProxy<T>(methodInterface);
		//返回实例化对象
		return (T) Proxy.newProxyInstance(
				methodInterface.getClassLoader(),
				new Class[]{methodInterface},
				methodProxy);
	}
}