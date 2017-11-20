package java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * �Ƚ�ArrayList��LinkedList��ƽ������ʱ��
 * @author ����
 */
public class ListSearch {
	public static void main(String[] args) {
		System.out.println("-------ArrayList Search------");
		search("ArrayList");
		System.out.println("-------LinkedList Search------");
		search("LinkedList");
	}

	//���Է���
	public static void search(String choose){
		final int M = 1000_000;//Ԫ�ظ���
		final int N = 100;//���Ҵ���
		//�������ϲ���ʼ��
		List<String> strs = null;
		if("ArrayList".equals(choose)){
			strs = new ArrayList<String>();
		}else if("LinkedList".equals(choose)){
			strs = new LinkedList<String>();
		}
		for (int j = 0; j < M; j++) {
			strs.add("str-"+j);
		}
		// ����N�β��Ҳ�ͳ�Ʋ���ʱ��ƽ��ֵ
		int avg = 0;
		for (int i = 0; i < N; i++) {
			// ����strs��Ԫ�ص�˳��
			Collections.shuffle(strs);
			long start = System.currentTimeMillis();
			String target = "str-10000";
			for (String str : strs) {
				if (target.equals(str)) {break;}
			}
			long end = System.currentTimeMillis();
			avg += end - start;
		}
		System.out.printf("��%d��Ԫ�ز���%d��,ƽ������%d����%n",M,N,avg);
	}
}