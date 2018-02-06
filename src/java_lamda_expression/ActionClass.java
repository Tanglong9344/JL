package java_lamda_expression;

import java.util.List;

/**
 * more and more abstract to show the benefits of functional programming
 *
 * @author ÌÆÁú
 *
 */
public class ActionClass {
	public static void main(String[] args) {
		List<String> list = java_common.CommonUtils.getList(3);
		// 1 object
		System.out.println("Way-1:");
		show(list, new Action<String>() {
			@Override
			public void show(String value) {
				System.out.println(value);
			}
		});
		// 2 function
		System.out.println("Way-2:");
		show(list, v->System.out.println(v));
		// 3 reference
		System.out.println("Way-3:");
		show(list, System.out::println);
	}

	/** a method that using interface <code>Action</code> */
	public static <V> void show(List<V> list, Action<V> action) {
		for(V v:list) {
			action.show(v);
		}
	}
}

/** Action interface that shows element */
interface Action<V>{
	void show(V value);
}