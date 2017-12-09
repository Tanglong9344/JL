package java_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator ������
 * @author ����
 */
public class IteratorTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		//��5��Hero��������
		for (int i = 1; i <= 5; i++) {
			list.add("string-"+i);
		}

		//�ڶ��ֱ�����ʹ�õ�����
		System.out.println("--------ʹ��while��iterator-------");
		Iterator<String> it= list.iterator();
		//���ʼ��λ���ж�"��һ��"λ���Ƿ�������
		//����о�ͨ��nextȡ���������Ұ�ָ�������ƶ�
		//ֱ��"��һ��"λ��û������
		while(it.hasNext()){
			System.out.println(it.next());
		}

		//��������forд��
		System.out.println("--------ʹ��for��iterator-------");
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());
		}
	}
}