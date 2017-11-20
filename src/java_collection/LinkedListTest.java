package java_collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LinkedList
 * ���ʺϱ�������
 * �ʺϲ���ɾ��
 * @author ����
 */
public class LinkedListTest {
	public static void main(String[] args) {
		//���󴴽�
		LinkedList<String> ll = new LinkedList<>();
		System.out.println(ll.toString());
		//�ڱ�β���
		ll.addLast("AAA");
		System.out.println("addLast:"+ll.toString());
		//�ڱ�ͷ���
		ll.addFirst("BBB");
		System.out.println("addFirst:"+ll.toString());

		//Ԫ�ػ�ȡ
		System.out.println("getLast:"+ll.getLast());
		System.out.println("getFirst:"+ll.getFirst());
		//Ԫ��ɾ��
		System.out.println("removeLast:"+ll.removeLast());
		System.out.println("removeFirst:"+ll.removeFirst());

		//LinkedListʵ��Queue
		Queue<String> que = new LinkedList<String>();
		System.out.println("\n���Ԫ��:"+que.offer("AAA"));
		que.offer("SSS");
		System.out.println("ɾ��������ͷԪ�أ�"+que.poll());
		System.out.println("����ͷԪ�أ�"+que.peek());
	}
}