package java_collection;

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
		//将数组转为集合后使用forEach方法
		Arrays.asList(strs).forEach(s->System.out.println(s));
		//注意：Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组
		//list.add("DDD");//报错：java.lang.UnsupportedOperationException
		//数组数值改变对应的集合数值也会改变
		strs[0]="aaa";
		list.forEach(s->System.out.println(s));

		List<String> lists = new ArrayList<String>();
		lists.add("XXX");
		lists.add("YYY");
		lists.add("ZZZ");
		//必须先根据集合大小新建数组，不能使用无参转换方法lists.toArray()
		String[] str = new String[lists.size()];
		//集合转数组
		lists.toArray(str);
		lists.remove(0);//集合操作不会影响数组
		System.out.println("\n"+Arrays.toString(str));
	}
}