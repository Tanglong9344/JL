package java_collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> names = new HashSet<String>();
		HashSet<String> names2 = new HashSet<String>();
		
		names.add("green");	
		System.out.println(names);
		//�ڶ��β���ͬ�������ݣ��ǲ岻��ȥ�ģ�������ֻ�ᱣ��һ��
		names.add("green");
		names.add("Red");
		System.out.println(names);
		
		names2.add("Blue");
		names2.add("Black");
		names.addAll(names2);
		System.out.println(names);
		
		//for����
		System.out.println("for����:");
		for(String str:names){
			System.out.println(str);
		}
		
		//����������
		System.out.println("����������:");
		for(Iterator<String> iterator=names.iterator();iterator.hasNext();){
			System.out.println(iterator.next());
		}
	}
}
