package java_collection;

import java.util.HashMap;

public class HashMapSearch {
	public static void main(String[] args) {
		HashMap<String,Hero> heroMap = new HashMap<String,Hero>();
		for (int j = 0; j < 2000000; j++) {
			Hero h = new Hero("Hero" + j);
			heroMap.put(h.name, h);
		}
		System.out.println("数据准备完成");
		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			//查找名字是Hero1000000的对象
			Hero target = heroMap.get("Hero1000000");
			System.out.println("找到了 hero!" + target.name);
			long end = System.currentTimeMillis();
			long elapsed = end - start;
			System.out.println("第"+(i+1)+"次,一共花了：" + elapsed + " 毫秒");
		}
	}
}
