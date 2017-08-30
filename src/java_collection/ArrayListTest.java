package java_collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		ArrayList<String> heros = new ArrayList<String>();
		long i = 10;
		while ((i--) > 0) {
			// ���Ԫ��
			if (i > 5) {
				heros.add("����");
			}
			// �Ƴ�Ԫ��
			else {
				heros.remove((i + 5));
			}
			System.err.println("�����С:" + heros.size());
		}
		// ���
		heros.clear();
		System.err.println("�����С:" + heros.size() + "\n\n");

		List<Object> hero = new ArrayList<>();
		while (i++ < 10) {
			// ���Ԫ��
			if (i < 5) {
				hero.add("����");
			}
			// �Ƴ�Ԫ��
			else {
				hero.add((new Hero("hero" + i, 12)));
			}
			System.err.println("�����С:" + hero.size());
			System.out.println(hero + "\n");
		}
		// ���
		hero.clear();
		System.err.println("�����С:" + hero.size());
	}
}
