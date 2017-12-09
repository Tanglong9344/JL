package java_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap vs HashTable
 * @author ����
 */
public class HashMapAndHashTable {
	public static void main(String[] args) {
		//HashMap��Hashtable��ʵ����Map�ӿڣ����Ǽ�ֵ�Ա������ݵķ�ʽ
		HashMap<String,String> hashMap = new HashMap<String,String>();
		//HashMap������null��key,��value
		//hashMap.put(null, "123");
		//hashMap.put("123", null);
		//System.out.println(hashMap.get("null"));
		//System.out.println(hashMap.get("123"));
		//Hashtable<String,String> hashtable = new Hashtable<String,String>();
		//Hashtable������null��key��������null��value
		//hashtable.put(null, "123");
		//hashtable.put("123", null);
		final int N = 5;
		for(int i=0;i<N;i++){
			hashMap.put(String.valueOf(i), "hashMap"+i);
		}
		System.out.println("��תǰ:"+hashMap);
		mapReverse(hashMap);
		System.out.println("��ת��:"+hashMap);
	}

	public static void mapReverse(Map<String, String> map){
		Set<String> keys = map.keySet();
		Collection<String> values = map.values();

		System.out.println("��:"+keys);
		System.out.println("ֵ:"+values);
	}
}