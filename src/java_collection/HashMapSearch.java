package java_collection;

import java.util.HashMap;

/**
 * HashMap 数据检索
 * @author 唐龙
 */
public class HashMapSearch {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		// 初始化
		for (int i = 1; i <= 2000000; i++) {
			map.put("K"+i,"V"+i);
		}
		System.out.println("初始数据:" + map);

		for (int i = 1; i <= 10; i++) {
			long start = System.currentTimeMillis();
			//查找名字是K10000的对象
			String target = map.get("K10000");
			System.out.println("找到目标" + target);
			long end = System.currentTimeMillis();
			System.out.println("第"+ i +"次,一共花了：" + (end - start) + "毫秒");
		}
	}
}