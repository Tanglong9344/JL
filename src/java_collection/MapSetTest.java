package java_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSetTest {
	static final int N = 5;
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();
		//初始化
		for(int i=1;i<=N;i++) {
			hashMap.put("0"+i,"数值"+i);
		}
		System.out.println(hashMap);

		//get keySet
		Set<String> set = hashMap.keySet();
		System.out.println(set);
		//contains()
		System.out.println("set.contains(\"01\"):"+set.contains("01"));
		System.out.println("set.contains(\"10\"):"+set.contains("10"));

		//get values
		Collection<String> values = hashMap.values();
		System.out.println(values);
		//contains()
		System.out.println("values.contains(\"数值1\"):"+values.contains("数值1"));
		System.out.println("values.contains(\"数值10\"):"+values.contains("数值10"));
	}
}