package java_collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String,String> hm = new HashMap<>();
		hm.put("h0", "物理英雄");
		hm.put("h1", "魔法英雄");
		hm.put("h2", "坦克");

		System.out.println(hm.size());
		for(int i=0;i<hm.size();i++){
			System.out.println(hm.get("h"+i));
		}

		hm.put("h3", "猪八戒");
		hm.put("h4", "孙悟空");
		System.out.println(hm.size());
		for(int i=0;i<hm.size();i++){
			System.out.println(hm.get("h"+i));
		}

		System.out.println(hm.toString());
		String hmStr = hm.toString().substring(1,hm.toString().length()-1);
		String[] hmStrSub = hmStr.split(",");
		for(String str:hmStrSub){
			String[] strSub = str.split("=");
			System.out.print(" "+strSub[0]);
			System.out.println(":"+strSub[1]);
		}

		System.out.println("HashMap健集合："+hm.keySet());
		System.out.println("HashMap值集合："+hm.values());
	}
}