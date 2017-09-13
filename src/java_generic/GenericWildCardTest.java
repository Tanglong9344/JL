package java_generic;

import java.util.ArrayList;

public class GenericWildCardTest {
	//java 泛型通配符
	public static void main(String[] args) {
		ArrayList<Hero> heroList = new ArrayList<Hero>();
		//?泛型通配符，表示任意泛型
		ArrayList<?> generalList = heroList;
		//?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
		//所以只能以Object的形式取出来
		System.out.println("泛型对象："+generalList);
		//?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
		//所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
		//generalList.add(new String()); //编译错误 因为?代表任意泛型，很有可能不是String
		//generalList.add(new Hero()); //编译错误 因为?代表任意泛型，很有可能不是Hero
		//generalList.add(new HeroChild()); //编译错误  因为?代表任意泛型，很有可能不是HeroChild
	}
}