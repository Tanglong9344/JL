package java_generic;

import java.util.ArrayList;

public class GenericSuperTest {
	public static void main(String[] args) {
		ArrayList<? super Hero> heroList = new ArrayList<Object>();
		//? super Hero 表示 heroList的泛型是Hero或者其父类泛型
		//所以就可以插入Hero
		heroList.add(new Hero());
		//也可以插入Hero的子类
		heroList.add(new HeroChild());
		//但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Hero会失败
		//Hero h= heroList.get(0);
	}
}
