package java_collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		ArrayList<String> heros = new ArrayList<String>();
		long i = 10;
		while ((i--) > 0) {
			// 添加元素
			if (i > 5) {
				heros.add("盖伦");
			}
			// 移除元素
			else {
				heros.remove((i + 5));
			}
			System.err.println("数组大小:" + heros.size());
		}
		// 清空
		heros.clear();
		System.err.println("数组大小:" + heros.size() + "\n\n");

		List<Object> hero = new ArrayList<>();
		while (i++ < 10) {
			// 添加元素
			if (i < 5) {
				hero.add("盖伦");
			}
			// 移除元素
			else {
				hero.add((new Hero("hero" + i, 12)));
			}
			System.err.println("数组大小:" + hero.size());
			System.out.println(hero + "\n");
		}
		// 清空
		hero.clear();
		System.err.println("数组大小:" + hero.size());
	}
}
