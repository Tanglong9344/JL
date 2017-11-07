package java_collection_map;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> heros = new ArrayList<String>();
		long i = 10;
		while ((i--) > 0) {
			if (i > 5) {
				heros.add("盖伦");// 添加元素
			}
			else {
				heros.remove((i + 5));// 移除元素
			}
			System.err.println("数组大小:" + heros.size());
		}
		// 清空
		heros.clear();
		System.err.println("数组大小:" + heros.size() + "\n\n");

		List<Object> hero = new ArrayList<>();
		while (i++ < 10) {
			if (i < 5) {
				hero.add("盖伦");// 添加元素
			}
			else {
				hero.add((new Hero("hero" + i, 12)));// 移除元素
			}
			System.err.println("数组大小:" + hero.size());
			System.out.println(hero + "\n");
		}
		// 清空
		hero.clear();
		System.err.println("数组大小:" + hero.size());
	}
}