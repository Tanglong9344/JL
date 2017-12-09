package java_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator 迭代器
 * @author 唐龙
 */
public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		//放5个Hero进入容器
		for (int i = 1; i <= 5; i++) {
			list.add("string-"+i);
		}

		//第二种遍历，使用迭代器
		System.out.println("--------使用while的iterator-------");
		Iterator<String> it= list.iterator();
		//从最开始的位置判断"下一个"位置是否有数据
		//如果有就通过next取出来，并且把指针向下移动
		//直达"下一个"位置没有数据
		while(it.hasNext()){
			System.out.println(it.next());
		}

		//迭代器的for写法
		System.out.println("--------使用for的iterator-------");
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
}