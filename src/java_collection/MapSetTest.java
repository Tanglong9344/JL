package java_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * MapSet 测试
 * @author 唐龙
 */
public class MapSetTest {
	static final int N = 5;
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();

		//初始化
		for(int i=1;i<=N;i++) {
			hashMap.put("K"+i,"V"+i);
		}
		System.out.println("hashMap:"+hashMap);

		//使用Map的foreach方法遍历
		hashMap.forEach(new BiConsumer<String,String>() {
			@Override
			public void accept(String k, String v) {
				System.out.print(k + ":" + v + ", ");
			}
		});
		System.out.println();

		//get keySet with keySet
		Set<String> keyset = hashMap.keySet();
		System.out.println("keyset:"+keyset);

		// Set is a view of Map, any modification on the Set
		// will be reflected to the Map and vice-versa
		hashMap.remove("K1");
		System.out.println("hashMap.remove(\"K1\"): "+keyset);

		//get entry with entrySet
		Set<Entry<String, String>> entryset = hashMap.entrySet();
		System.out.println("entrySet:"+entryset);
		//contains()
		System.out.println("set.contains(\"01\"):"+keyset.contains("01"));
		System.out.println("set.contains(\"10\"):"+keyset.contains("10"));

		//get values
		Collection<String> values = hashMap.values();
		System.out.println(values);
		//contains()
		System.out.println("values.contains(\"数值1\"):"+values.contains("数值1"));
		System.out.println("values.contains(\"数值10\"):"+values.contains("数值10"));
	}
}