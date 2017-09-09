package java_collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		Map<String,String> hm = new HashMap<>();
		hm.put("h0", "����Ӣ��");
		hm.put("h1", "ħ��Ӣ��");
		hm.put("h2", "̹��");

		System.out.println(hm.size());
		for(int i=0;i<hm.size();i++){
			System.out.println(hm.get("h"+i));
		}

		hm.put("h3", "��˽�");
		hm.put("h4", "�����");
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

		System.out.println("HashMap�����ϣ�"+hm.keySet());
		System.out.println("HashMapֵ���ϣ�"+hm.values());
	}
}