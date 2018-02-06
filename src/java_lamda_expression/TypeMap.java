package java_lamda_expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Type transform: Object vs Lambda Expression
 *
 * @author ÌÆÁú
 *
 */
public class TypeMap {
	public static void main(String[] args) {
		List<String> list = java_common.CommonUtils.getList(10);
		System.out.println(list);
		// get the last character's value of a string
		List<Integer> list2 = map(list, new Mapper<String, Integer>() {
			@Override
			public Integer map(String value) {
				return Integer.parseInt(value.charAt(value.length()-1) + "");
			}
		});
		System.out.println("Before Java8: " + list2);
		// Lambda expression in java8
		System.out.println("LE in Java8 : " + map(list, value->Integer.parseInt(value.charAt(value.length()-1) + "")));

		// return square of the values
		List<Integer> listInteger = new ArrayList<Integer>();
		listInteger.add(1);
		listInteger.add(3);
		listInteger.add(8);
		Mapper<Integer, Integer> map = new Mapper<Integer, Integer>(){
			@Override
			public Integer map(Integer value) {
				return value * value;
			}
		};
		System.out.println("Before Map   : " + listInteger);
		System.out.println("After Map    : " + map(listInteger, map));
		// Lambda expression is more simple and clear
		Mapper<Integer, Integer> square = v->v*v;
		System.out.println("1 LE in Java8: " + map(listInteger, square));
		System.out.println("2 LE in Java8: " + map(listInteger, v->v*v));
	}

	/** Transform a list values of type <code>V</code> to type <code>M</code>
	 *  using anonymous class to implement the interface
	 * */
	public static <V, M> List<M> map(List<V> list, Mapper<V, M> mapper) {
		List<M> mapped = new ArrayList<M>(list.size());
		for (V v : list) {
			mapped.add(mapper.map(v));
		}
		return mapped;
	}
}

/**
 * Interface Mapper
 * transform the value of type <code>V</code> to type <code>M</code>
 *
 * @param <V>
 * @param <M>
 */
interface Mapper<V, M> {
	/** type map */
	M map(V value);

	/** default method */
	default void msg() {
		System.out.println("This is a default method in interface...");
	}
}