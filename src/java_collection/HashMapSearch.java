package java_collection;

import java.util.HashMap;

/**
 * HashMap ���ݼ���
 * @author ����
 */
public class HashMapSearch {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		// ��ʼ��
		for (int i = 1; i <= 2000000; i++) {
			map.put("K"+i,"V"+i);
		}
		System.out.println("��ʼ����:" + map);

		for (int i = 1; i <= 10; i++) {
			long start = System.currentTimeMillis();
			//����������K10000�Ķ���
			String target = map.get("K10000");
			System.out.println("�ҵ�Ŀ��" + target);
			long end = System.currentTimeMillis();
			System.out.println("��"+ i +"��,һ�����ˣ�" + (end - start) + "����");
		}
	}
}