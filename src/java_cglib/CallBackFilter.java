package java_cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.NoOp;

/**
 * callback work with callbackFilter
 *
 * @author tanglong
 *
 */
public class CallBackFilter {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		CallbackHelper callbackHelper = new CallbackHelper(CallBackFilter.class, new Class[0]) {
			@Override
			protected Object getCallback(Method method) {
				if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
					return new FixedValue() {
						@Override
						public Object loadObject() throws Exception {
							return "Hello cglib!";
						}
					};
				} else {
					return NoOp.INSTANCE; // A singleton provided by NoOp.
				}
			}
		};
		enhancer.setSuperclass(CallBackFilter.class);
		enhancer.setCallbackFilter(callbackHelper);
		enhancer.setCallbacks(callbackHelper.getCallbacks());
		CallBackFilter proxy = (CallBackFilter) enhancer.create();
		System.out.println(proxy.test());
		System.out.println(proxy.hashCode()); // Does not throw an exception or result in an endless loop.
	}

	/** test method */
	public String test() {
		return "Hello world!";
	}
}