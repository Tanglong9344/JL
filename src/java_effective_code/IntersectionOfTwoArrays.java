package java_effective_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 两个数组的交集O(m+n)
 *
 * @author 唐龙
 *
 */
public class IntersectionOfTwoArrays {
	static final int N = 10;
	static final int RANGE = 30;
	public static void main(String[] args) {
		Random r = new Random();
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		for(int i=0;i<N;i++) {
			s1.add(r.nextInt(RANGE) + "");
			s2.add(r.nextInt(RANGE) + "");
		}

		String[] a = new String[s1.size()];
		String[] b = new String[s2.size()];
		s1.toArray(a);
		s2.toArray(b);

		System.out.println("a      : " + Arrays.toString(a));
		System.out.println("b      : " + Arrays.toString(b));
		System.out.println("Common : " + Arrays.toString(getIntersection(a, b)));
	}

	/**get Intersection of two arrays*/
	private static String[] getIntersection (String[] a, String[] b) {
		List<String> list = new ArrayList<String>();
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		for(int i=0,len=a.length;i<len;i++) {
			map.put(a[i], true);
		}

		// get the same data
		for(int i=0,len=b.length;i<len;i++) {
			if(map.get(b[i]) != null) {
				list.add(b[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}
}