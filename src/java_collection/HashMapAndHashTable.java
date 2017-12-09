package java_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap vs HashTable
 * @author 唐龙
 */
public class HashMapAndHashTable {
	public static void main(String[] args) {
		//HashMap和Hashtable都实现了Map接口，都是键值对保存数据的方式
		HashMap<String,String> hashMap = new HashMap<String,String>();
		//HashMap可以用null作key,作value
		//hashMap.put(null, "123");
		//hashMap.put("123", null);
		//System.out.println(hashMap.get("null"));
		//System.out.println(hashMap.get("123"));
		//Hashtable<String,String> hashtable = new Hashtable<String,String>();
		//Hashtable不能用null作key，不能用null作value
		//hashtable.put(null, "123");
		//hashtable.put("123", null);
		final int N = 5;
		for(int i=0;i<N;i++){
			hashMap.put(String.valueOf(i), "hashMap"+i);
		}
		System.out.println("翻转前:"+hashMap);
		mapReverse(hashMap);
		System.out.println("翻转后:"+hashMap);
	}

	public static void mapReverse(Map<String, String> map){
		Set<String> keys = map.keySet();
		Collection<String> values = map.values();

		System.out.println("健:"+keys);
		System.out.println("值:"+values);
	}
}