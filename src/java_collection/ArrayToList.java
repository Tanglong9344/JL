package java_collection;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays to List
 *
 * @author ÌÆÁú
 *
 */
public class ArrayToList {
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println(list1);

		String[] strs = new String[] {"str1", "str2", "str3"};
		List<String> list2 = Arrays.asList(strs);
		System.out.println(list2);
	}
}