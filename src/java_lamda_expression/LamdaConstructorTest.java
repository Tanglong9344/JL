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

		//������
		List list1 = getList(s);
		System.out.println("������:\n"+list1);
		//Lambda���ʽ
		List list2 = getList(()->new ArrayList());
		System.out.println("Lambda���ʽ:\n"+list2);
		//���ù�����
		List list3 = getList(ArrayList::new);
		System.out.println("���ù�����:\n"+list3);
	}
	@SuppressWarnings("rawtypes")
	public static List getList(Supplier<List> s){
		return s.get();
	}
}
