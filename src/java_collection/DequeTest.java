package java_collection;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ˫�˶���
 */

public class DequeTest {
	public static void main(String[] args) {
		final int N = 5;
		final int RANGE = 10;
		Deque<Integer> deque = new ArrayDeque<Integer>();
		//---ʧ�ܷ����쳣--
		//addLast
		for(int i=0;i<N;i++){
			deque.addLast((int)(Math.random()*RANGE));
		}
		System.out.println("deque=" + deque);

		//addFirst
		for(int i=0;i<N;i++){
			deque.addFirst((int)(Math.random()*RANGE));
		}
		System.out.println("deque=" + deque);

		//---ʧ�ܷ����쳣--
		//removeFirst
		deque.removeFirst();
		//removeLast
		deque.removeLast();
		System.out.println("deque=" + deque);

		//getFirst
		System.out.println(deque.getFirst());
		//getLast
		System.out.println(deque.getLast());

		//---ʧ�ܷ���false--
		//offerFirst
		deque.offerFirst(666);
		//offerLast
		deque.offerLast(999);
		System.out.println("deque=" + deque);

		//---ʧ�ܷ���null--
		//��ȡ�����Ƴ�Ԫ��
		//peekFirst
		System.out.println(deque.peekFirst());
		//peekLast
		System.out.println(deque.peekLast());
		System.out.println("deque=" + deque);

		//��ȡ���Ƴ�Ԫ��
		//pollFirst
		System.out.println(deque.pollFirst());
		//pollLast
		System.out.println(deque.peekLast());
		System.out.println("deque=" + deque);
	}
}