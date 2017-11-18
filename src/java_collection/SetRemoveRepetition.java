package java_collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Set 中元素不会重复,可以利用这个特性进行元素去重
 * @author 唐龙
 */
public class SetRemoveRepetition {
	public static void main(String[] args) {
		String[] strs = {"aaa","bbb","bbb","ccc","ccc","ddd"};
		System.out.println("数组去重前："+Arrays.toString(strs));

		//利用Set去重
		Set<String> set = new HashSet<String>(Arrays.asList(strs));

		strs = new String[set.size()];
		set.toArray(strs);
		System.out.println("数组去重后："+Arrays.toString(strs));
	}
}