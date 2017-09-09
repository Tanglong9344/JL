package java_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
	public static void main(String[] args) { // java��������ڴ�
		hashSetResult();
		treeSetResult();
		linkedHashSetResult();

		Set<String> hashSet = new HashSet<String>();
		// ���÷������Ԫ��
		addSetElement(hashSet);
		//���Ԫ��
		hashSet.add("���÷�����2");
		System.out.println("hashSet���Ԫ��: ");
		// ���÷�����ʾԪ��
		showElement(hashSet);
		//ɾ��Ԫ��
		hashSet.remove("���÷�����2");
		System.out.println("hashSetɾ��Ԫ��: ");
		// ���÷�����ʾԪ��
		showElement(hashSet);
	}

	// ʹ��HashSet����Ԫ��
	public static void hashSetResult() {
		Set<String> hashSet = new HashSet<String>();
		addSetElement(hashSet);
		System.out.println("HashSet�洢������Ԫ�أ� ");
		showElement(hashSet);
	}

	// ʹ��TreeSet����Ԫ��
	public static void treeSetResult() {
		Set<String> treeSet = new TreeSet<String>();
		// ���÷�����ʼ��Ԫ��
		addSetElement(treeSet);
		System.out.println("TreeSet�洢������Ԫ�أ�");
		// ���÷�����ʾԪ��
		showElement(treeSet);
	}

	// ʹ��LinkedHashSet����Ԫ��
	public static void linkedHashSetResult() {
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		// ���÷�����ʼ��Ԫ��
		addSetElement(linkedHashSet);
		System.out.println("LinkedHashSet�洢������Ԫ�أ�");
		// ���÷�����ʾԪ��
		showElement(linkedHashSet);
	}

	// ��ʼ��Set��Ԫ��
	public static void addSetElement(Set<String> set) {
		if (set != null) {
			set.add("���÷�����");
			set.add("�������");
			set.add("���÷�");
		}
	}

	// ���set��Ԫ��
	public static void showElement(Set<String> set) {
		if (set != null && set.size() > 0) {
			// ��õ�����Iterator
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} else {
			System.out.println("û��Ԫ�أ�");
		}
		System.out.println();
	}
}