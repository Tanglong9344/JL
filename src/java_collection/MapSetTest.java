package java_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * MapSet ����
 * @author ����
 */
public class MapSetTest {
	static final int N = 5;
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();

		//��ʼ��
		for(int i=1;i<=N;i++) {
			hashMap.put("K"+i,"V"+i);
		}
		System.out.println("hashMap:"+hashMap);

		//ʹ��Map��foreach��������
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
		System.out.println("values.contains(\"��ֵ1\"):"+values.contains("��ֵ1"));
		System.out.println("values.contains(\"��ֵ10\"):"+values.contains("��ֵ10"));
	}
}