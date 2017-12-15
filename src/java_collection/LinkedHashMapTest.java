package java_collection;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap����
 * @author ����
 */
public class LinkedHashMapTest {
	public static void main(String[] args) {
		LinkedHashMap<String,String> hm = new LinkedHashMap<String,String>();
		// ��ʼ��
		for (int i = 1; i <= 5; i++) {
			hm.put("K"+i,"V"+i);
		}
		System.out.println("��ʼ����:" + hm);

		//remove
		hm.remove("K1");
		System.out.println(hm.get("K1"));

		System.out.println("keys: " + hm.keySet());
		System.out.println("values: " + hm.values());
		System.out.println("keys & values: " + hm.entrySet());
	}
}