package design_mode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ʹ�÷������ʵ�ֶ�̬����
 *
 * @author tanglong
 *
 */
public class DynamicProxyMode {
	public static void main(String[] args) {
		InterfaceRootImpl iri = new InterfaceRootImpl();
		InterfaceRootProxy irip = new InterfaceRootProxy();
		InterfaceRoot ir = (InterfaceRoot) irip.bind(iri);
		ir.operate();
	}
}

/** define a interface */
interface InterfaceRoot {
	public void operate();
}

/** implement the interface */
class InterfaceRootImpl implements InterfaceRoot {
	@Override
	public void operate() {
		System.out.println("operating...");
	}
}

/**
 * create dynamic proxy class
 * implementing interface 'InvocationHandler'
 */
class InterfaceRootProxy implements InvocationHandler {
	private Object target = null;

	// bind target object
	public Object bind(Object target) {
		this.target = target;
		//ͨ��������ƣ�����һ�����������ʵ�������ء�
		// 1.�������
		// 2.�ӿ�
		// 3.handlerʵ����
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				this);
	}

	// ��װ���÷���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result=null;
		System.out.println("Before invoke");
		result=method.invoke(target, args);
		System.out.println("After invoke");
		return result;
	}
}