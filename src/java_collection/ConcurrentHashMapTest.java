package java_collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap
 *
 * @author ÌÆÁú
 */
public class ConcurrentHashMapTest {
	static final int N = 5;
	public static void main(String[] args) {
		Map<Object, Object> chm = new ConcurrentHashMap<>();
		// putIfAbsent
		chm.putIfAbsent("K1", "V1");
		chm.putIfAbsent("K1", "V2");
		chm.putIfAbsent("K3", "V3");
		System.out.println(chm);

		// put
		chm.put("K1", "V11");
		chm.put("K1", "V22");
		chm.put("K3", "V33");
		System.out.println(chm);
	}
}