package java_collection_map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**HashMap
 * Hashtable
 * LinkedHashMap
 * TreeMap
 * 都是
 * 接口java.util.Map
 * 的实现类
 * */

public class MapList {
	public static void main(String[] args) {
		printHashMap(); // 操作HashMap显示图书种类
		printHashTable(); // 操作Hashtable显示图书种类
		printTreeMap(); // 操作TreeMap显示图书种类
		printLinkedHashMap(); // 操作LinkedHashMap显示图书种类
	}

	///HashMap
	public static void printHashMap() {
		// hashMap是无序的
		//HashMap，允许键或值为null
		//键值相同的数据只显示最后一条
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("01", "计算机类图书1");
		hashMap.put("01", "计算机类图书2");
		hashMap.put("02", "外语类图书");
		hashMap.put("03", "音乐类图书");
		hashMap.put("04", null);
		hashMap.put(null, "食谱类图书");

		// 获得迭代器Iterator
		Iterator<String> iterator = hashMap.keySet().iterator();
		System.out.println("1.操作HashMap显示图书种类:");
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(hashMap.get(key));
		}
		System.out.println();
	}

	//HashTable
	public static void printHashTable() {
		// Hashtable是无序的
		//HashTable不允许键或值为null
		//键值相同的数据只显示最后一条
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("01", "计算机类图书1");
		hashTable.put("01", "计算机类图书2");
		hashTable.put("02", "外语类图书");
		hashTable.put("03", "音乐类图书");
		//hashTable.put("04", null);
		//hashTable.put(null, "食谱类图书");
		// 获得迭代器Iterator
		Iterator<String> iterator = hashTable.keySet().iterator();
		System.out.println("2.操作Hashtable显示图书种类:");
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(hashTable.get(key));
		}
		System.out.println();
	}

	//HashTree
	public static void printTreeMap() {
		// HashTree是有序的，默认按键升序排序
		//键值相同的数据只显示最后一条
		//键不允许为null，值可以为null
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("01", "计算机类图书1");
		treeMap.put("01", "计算机类图书2");
		treeMap.put("04", "外语类图书");
		treeMap.put("03", "音乐类图书");
		//treeMap.put(null, "这里没有图书");
		treeMap.put("02", null);
		// 获得迭代器Iterator
		Iterator<String> iterator = treeMap.keySet().iterator();
		System.out.println("3.操作TreeMap显示图书种类:");
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(treeMap.get(key));
		}
		System.out.println();
	}

	//LinkedHashMap
	public static void printLinkedHashMap() {
		//ArrayList是无序的
		//键值相同的数据只显示最后一条
		//允许键或值为null
		Map<String,String> linkedHashMap = new LinkedHashMap<String,String>();
		linkedHashMap.put("01","计算机类图书1");
		linkedHashMap.put("01","计算机类图书2");
		linkedHashMap.put("03","音乐类图书");
		linkedHashMap.put("04","医学类图书");
		linkedHashMap.put("02","外语类图书");
		linkedHashMap.put(null, "这里没有图书");
		linkedHashMap.put("02", null);
		Iterator<String> iterator = linkedHashMap.keySet().iterator();
		System.out.println("4.操作LinkedHashMap显示图书种类:");
		while(iterator.hasNext()){
			Object key = iterator.next();
			System.out.println(linkedHashMap.get(key));
		}
		System.out.println();
	}
}