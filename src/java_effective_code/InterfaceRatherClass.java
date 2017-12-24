package java_effective_code;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

/**
 * Prefer Interface to implemented class
 *
 * @author ÌÆÁú
 *
 */
public class InterfaceRatherClass {
	static final int N = 5;
	public static void main(String[] args) {
		Map<String,String> map;//Interface
		Random r = new Random();
		// Randomly choose implemented class
		map = r.nextInt()%2 == 0 ? new HashMap<String,String>() : new Hashtable<String,String>();
		// Initialize
		for(int i=1;i<=N;i++){
			map.put("K"+i, "V"+i);
		}
		System.out.println(map);
		System.out.println(map.keySet());
		System.out.println(map.values());
	}
}