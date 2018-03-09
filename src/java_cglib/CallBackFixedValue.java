package java_cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;

/**
 * callback1: FixedValue
 *
 * @author tanglong
 *
 */
public class CallBackFixedValue {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CallBackFixedValue.class);
		enhancer.setCallback(new FixedValue() {
			@Override
			public Object loadObject() throws Exception {
				return "Hello cglib!";
			}
		});
		CallBackFixedValue sc = (CallBackFixedValue)enhancer.create();
		// invoke the 'tests' method
		System.out.println(sc.test());
		// final method can't be intercepted
		System.out.println(sc.getClass());
		// all others method except final mehods can also be intercepted
		try {
			System.out.println(sc.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(sc.toString());
		// 'hashcode' method will throw an exception
		// because of the different return type
		// System.out.println(sc.hashCode());
	}

	/** test method */
	public String test() {
		return "Hello world!";
	}
}