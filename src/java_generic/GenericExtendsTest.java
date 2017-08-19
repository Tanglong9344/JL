package java_generic;

import java.util.ArrayList;

public class GenericExtendsTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<HeroChild> heroChildList = new ArrayList<HeroChild>();
		heroChildList.add(new HeroChild());
		ArrayList<? extends Hero> heroList = heroChildList;
		//? extends Hero 表示这是一个Hero泛型的子类泛型
		Hero h= heroList.get(0);
		//但是，不能往里面放东西
		//heroList.add(new Hero());
	}
}
