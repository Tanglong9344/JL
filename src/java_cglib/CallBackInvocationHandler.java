package java_cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

/**
 * callback2: InvocationHandler
 *
 * @author tanglong
 *
 */
public class CallBackInvocationHandler {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CallBackFixedValue.class);
		enhancer.setCallback(new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
					return "Hello cglib!";
				} else {
					throw new RuntimeException("Do not know what to do...");
				}
			}
		});
		CallBackFixedValue sc = (CallBackFixedValue)enhancer.create();
		// invoke the 'tests' method
		System.out.println(sc.test());
		// throw RuntimeException
		System.out.println(sc.hashCode());
	}

	/** test method */
	public String test() {
		return "Hello world!";
	}
}