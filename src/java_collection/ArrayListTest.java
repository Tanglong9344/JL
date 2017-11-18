package java_collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> heros = new ArrayList<String>();
		long i = 10;
		while ((i--) > 0) {
			if (i > 5) {
				heros.add("����");// ���Ԫ��
			}
			else {
				heros.remove((i + 5));// �Ƴ�Ԫ��
			}
			System.err.println("�����С:" + heros.size());
		}
		// ���
		heros.clear();
		System.err.println("�����С:" + heros.size() + "\n\n");

		List<Object> hero = new ArrayList<>();
		while (i++ < 10) {
			if (i < 5) {
				hero.add("����");// ���Ԫ��
			}
			else {
				hero.add((new Hero("hero" + i, 12)));// �Ƴ�Ԫ��
			}
			System.err.println("�����С:" + hero.size());
			System.out.println(hero + "\n");
		}
		// ���
		hero.clear();
		System.err.println("�����С:" + hero.size());
	}
}