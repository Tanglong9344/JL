package java_collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> names = new HashSet<String>();
		HashSet<String> names2 = new HashSet<String>();
		
		names.add("green");	
		System.out.println(names);
		//第二次插入同样的数据，是插不进去的，容器中只会保留一个
		names.add("green");
		names.add("Red");
		System.out.println(names);
		
		names2.add("Blue");
		names2.add("Black");
		names.addAll(names2);
		System.out.println(names);
		
		//for遍历
		System.out.println("for遍历:");
		for(String str:names){
			System.out.println(str);
		}
		
		//迭代器遍历
		System.out.println("迭代器遍历:");
		for(Iterator<String> iterator=names.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
	}
}
