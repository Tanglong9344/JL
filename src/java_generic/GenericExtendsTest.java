package java_generic;

import java.util.ArrayList;

public class GenericExtendsTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<HeroChild> heroChildList = new ArrayList<HeroChild>();
		heroChildList.add(new HeroChild());
		ArrayList<? extends Hero> heroList = heroChildList;
		//? extends Hero ��ʾ����һ��Hero���͵����෺��
		Hero h= heroList.get(0);
		//���ǣ�����������Ŷ���
		//heroList.add(new Hero());
	}
}
