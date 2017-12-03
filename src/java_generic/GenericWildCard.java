package java_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * java 泛型通配符
 * @author 唐龙
 */
public class GenericWildCard {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//?泛型通配符，表示任意泛型
		//?的缺陷1： ?代表任意泛型，即你不知道这个容器里面是什么类型
		List<?> gList = new ArrayList<String>();
		//所以只能以Object的形式取出来
		Object object = gList.get(0);
		//String str = gList.get(0);
		//Long l = gList.get(0);
		//?的缺陷2： 既然?代表任意泛型，所以，放哪种对象进去都有风险，结果就什么什么类型的对象都不能放进去
		//gList.add("str001");
		//gList.add(new Integer(002));
		//gList.add(new String("003"));
	}
}