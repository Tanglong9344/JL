package java_lamda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class LamdaConstructorTest {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Supplier<List> s = new Supplier<List>() {
			@Override
			public List get() {
				return new ArrayList();
			}
		};

		//匿名类
		List list1 = getList(s);
		System.out.println("匿名类:\n"+list1);
		//Lambda表达式
		List list2 = getList(()->new ArrayList());
		System.out.println("Lambda表达式:\n"+list2);
		//引用构造器
		List list3 = getList(ArrayList::new);
		System.out.println("引用构造器:\n"+list3);
	}
	@SuppressWarnings("rawtypes")
	public static List getList(Supplier<List> s){
		return s.get();
	}
}
