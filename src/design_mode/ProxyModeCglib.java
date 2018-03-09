package design_mode;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * code generate library
 * <url>https://github.com/cglib/cglib</url>
 * <jar>cglib-3.2.6.jar</jar>
 *
 * # references
 * 1.<url>https://github.com/cglib/cglib/wiki/Tutorial</url>
 * 2.<url>http://asm.ow2.org/</url>
 *
 * @author tanglong
 *
 */
public class ProxyModeCglib {
	public void test(){
		System.out.println("Hello cglib");
	}

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ProxyModeCglib.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("before method run...");
				Object result = proxy.invokeSuper(obj, args);
				System.out.println("after method run...");
				return result;
			}
		});
		ProxyModeCglib sample = (ProxyModeCglib) enhancer.create();
		sample.test();
	}
}