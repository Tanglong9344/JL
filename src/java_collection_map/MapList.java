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
 * ����
 * �ӿ�java.util.Map
 * ��ʵ����
 * */

public class MapList {
	public static void main(String[] args) {
		printHashMap(); // ����HashMap��ʾͼ������
		printHashTable(); // ����Hashtable��ʾͼ������
		printTreeMap(); // ����TreeMap��ʾͼ������
		printLinkedHashMap(); // ����LinkedHashMap��ʾͼ������
	}

	///HashMap
	public static void printHashMap() {
		// hashMap�������
		//HashMap���������ֵΪnull
		//��ֵ��ͬ������ֻ��ʾ���һ��
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("01", "�������ͼ��1");
		hashMap.put("01", "�������ͼ��2");
		hashMap.put("02", "������ͼ��");
		hashMap.put("03", "������ͼ��");
		hashMap.put("04", null);
		hashMap.put(null, "ʳ����ͼ��");

		// ��õ�����Iterator
		Iterator<String> iterator = hashMap.keySet().iterator();
		System.out.println("1.����HashMap��ʾͼ������:");
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(hashMap.get(key));
		}
		System.out.println();
	}

	//HashTable
	public static void printHashTable() {
		// Hashtable�������
		//HashTable���������ֵΪnull
		//��ֵ��ͬ������ֻ��ʾ���һ��
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("01", "�������ͼ��1");
		hashTable.put("01", "�������ͼ��2");
		hashTable.put("02", "������ͼ��");
		hashTable.put("03", "������ͼ��");
		//hashTable.put("04", null);
		//hashTable.put(null, "ʳ����ͼ��");
		// ��õ�����Iterator
		Iterator<String> iterator = hashTable.keySet().iterator();
		System.out.println("2.����Hashtable��ʾͼ������:");
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(hashTable.get(key));
		}
		System.out.println();
	}

	//HashTree
	public static void printTreeMap() {
		// HashTree������ģ�Ĭ�ϰ�����������
		//��ֵ��ͬ������ֻ��ʾ���һ��
		//��������Ϊnull��ֵ����Ϊnull
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("01", "�������ͼ��1");
		treeMap.put("01", "�������ͼ��2");
		treeMap.put("04", "������ͼ��");
		treeMap.put("03", "������ͼ��");
		//treeMap.put(null, "����û��ͼ��");
		treeMap.put("02", null);
		// ��õ�����Iterator
		Iterator<String> iterator = treeMap.keySet().iterator();
		System.out.println("3.����TreeMap��ʾͼ������:");
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(treeMap.get(key));
		}
		System.out.println();
	}

	//LinkedHashMap
	public static void printLinkedHashMap() {
		//ArrayList�������
		//��ֵ��ͬ������ֻ��ʾ���һ��
		//�������ֵΪnull
		Map<String,String> linkedHashMap = new LinkedHashMap<String,String>();
		linkedHashMap.put("01","�������ͼ��1");
		linkedHashMap.put("01","�������ͼ��2");
		linkedHashMap.put("03","������ͼ��");
		linkedHashMap.put("04","ҽѧ��ͼ��");
		linkedHashMap.put("02","������ͼ��");
		linkedHashMap.put(null, "����û��ͼ��");
		linkedHashMap.put("02", null);
		Iterator<String> iterator = linkedHashMap.keySet().iterator();
		System.out.println("4.����LinkedHashMap��ʾͼ������:");
		while(iterator.hasNext()){
			Object key = iterator.next();
			System.out.println(linkedHashMap.get(key));
		}
		System.out.println();
	}
}