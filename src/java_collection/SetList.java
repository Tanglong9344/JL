package java_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
	public static void main(String[] args) { // java程序主入口处
		hashSetResult();
		treeSetResult();
		linkedHashSetResult();

		Set<String> hashSet = new HashSet<String>();
		// 调用方法添加元素
		addSetElement(hashSet);
		//添加元素
		hashSet.add("经济法基础2");
		System.out.println("hashSet添加元素: ");
		// 调用方法显示元素
		showElement(hashSet);
		//删除元素
		hashSet.remove("经济法基础2");
		System.out.println("hashSet删除元素: ");
		// 调用方法显示元素
		showElement(hashSet);
	}

	// 使用HashSet操作元素
	public static void hashSetResult() {
		Set<String> hashSet = new HashSet<String>();
		addSetElement(hashSet);
		System.out.println("HashSet存储的数据元素： ");
		showElement(hashSet);
	}

	// 使用TreeSet操作元素
	public static void treeSetResult() {
		Set<String> treeSet = new TreeSet<String>();
		// 调用方法初始化元素
		addSetElement(treeSet);
		System.out.println("TreeSet存储的数据元素：");
		// 调用方法显示元素
		showElement(treeSet);
	}

	// 使用LinkedHashSet操作元素
	public static void linkedHashSetResult() {
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		// 调用方法初始化元素
		addSetElement(linkedHashSet);
		System.out.println("LinkedHashSet存储的数据元素：");
		// 调用方法显示元素
		showElement(linkedHashSet);
	}

	// 初始化Set的元素
	public static void addSetElement(Set<String> set) {
		if (set != null) {
			set.add("经济法基础");
			set.add("财务管理");
			set.add("经济法");
		}
	}

	// 输出set的元素
	public static void showElement(Set<String> set) {
		if (set != null && set.size() > 0) {
			// 获得迭代器Iterator
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} else {
			System.out.println("没有元素！");
		}
		System.out.println();
	}
}