package java_collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap
 * @author ÌÆÁú
 */
public class ConcurrentHashMapTest {
	static final int N = 5;
	public static void main(String[] args) {
		Map<Object, Object> chm = new ConcurrentHashMap<>();
		for(int i=1;i<=N;i++) {
			chm.put("K"+i, "V"+i);
		}
		System.out.println(chm);
	}
}