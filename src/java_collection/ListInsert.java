package java_collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * �Ƚ�ArrayList��LinkedList��Ԫ�ز���ƽ��ʱ��
 * @author ����
 */
public class ListInsert {
	public static void main(String[] args) {
		System.out.println("-------ArrayList Insert------");
		insert("ArrayList");
		System.out.println("-------LinkedList Insert------");
		insert("LinkedList");
	}

	//���Է���
	public static void insert(String choose){
		final int M = 1000_000;//Ԫ�ظ���
		//�������ϲ���ʼ��
		List<String> strs = null;
		if("ArrayList".equals(choose)){
			strs = new ArrayList<String>();
		}else if("LinkedList".equals(choose)){
			strs = new LinkedList<String>();
		}
		//����M��Ԫ������ʱ���ƽ��ֵ
		int avg = 0;
		long start = System.currentTimeMillis();
		for (int j = 0; j < M; j++) {
			strs.add("str-"+j);
		}
		long end = System.currentTimeMillis();
		avg += end - start;
		System.out.printf("����%d��Ԫ��ƽ������%d����%n",M,avg);
	}
}