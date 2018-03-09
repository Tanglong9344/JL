package java_cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * callback3: MethodInterceptor
 *
 * @author tanglong
 *
 */
public class CallBackMethodInterceptor {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CallBackFixedValue.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
					return "Hello cglib!";
				} else {
					return proxy.invokeSuper(obj, args);
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