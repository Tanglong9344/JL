package java_collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class HashSetAndLinkSetAndTreeSet {
	public static void main(String[] args) {
		HashSet<Integer> hashSet =new HashSet<Integer>();
		//HashSet�е����ݲ��ǰ��ղ���˳����
		hashSet.add(6);
		hashSet.add(8);
		hashSet.add(3);

		System.out.println(hashSet);

		LinkedHashSet<Integer> linkedSet =new LinkedHashSet<Integer>();
		//LinkedHashSet�е������ǰ��ղ���˳����
		linkedSet.add(6);
		linkedSet.add(8);
		linkedSet.add(3);

		System.out.println(linkedSet);
		
		TreeSet<Integer> treeSet =new TreeSet<Integer>();
		//TreeSet �е������ǽ����������
		treeSet.add(6);
		treeSet.add(8);
		treeSet.add(3);

		System.out.println(treeSet);
	}
}
