package java_collection_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 数组和集合相互转换
 * @author 唐龙
 */
public class ArrayConvertList {
	public static void main(String[] args) {
		String[] strs = {"AAA","BBB","CCC"};
		//数组转为集合
		List<String> list = Arrays.asList(strs);
		list.forEach(s->System.out.print(s+" "));

		List<String> lists = new ArrayList<String>();
		lists.add("XXX");
		lists.add("YYY");
		lists.add("ZZZ");
		//建立数组
		String[] str = new String[lists.size()];
		//集合转数组
		lists.toArray(str);
		System.out.println("\n"+Arrays.toString(str));
	}
}