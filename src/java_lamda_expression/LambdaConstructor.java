package java_lamda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Functional Constructor
 *
 * Using Interface Supplier<T>
 * @author 唐龙
 *
 */
public class LambdaConstructor {
	public static void main(String[] args) {
		//匿名类
		List<String> listAno = getList(new Supplier<List<String>>() {
			@Override
			public List<String> get() {
				return new ArrayList<String>();
			}
		});
		System.out.println("Anonymous Class      : "+listAno);

		//Lambda表达式
		List<String> listLam = getList(()->new ArrayList<String>());
		System.out.println("Lambda Expression    : "+listLam);

		//引用构造器
		List<String> listRef = getList(ArrayList::new);
		System.out.println("Reference Constructor: "+listRef);
	}

	/**
	 * @param s: Supplier<List<String>>
	 * @return : List<String>
	 */
	public static List<String> getList(Supplier<List<String>> s){
		return s.get();
	}
}