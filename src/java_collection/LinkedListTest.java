package java_collection;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<>();
		System.out.println(ll.toString());
		//LinkedList实现Deque
		ll.addLast("AAA");
		System.out.println(ll.toString());

		ll.addFirst("BBB");
		System.out.println(ll.toString());

		System.out.println(ll.getLast());

		System.out.println(ll.getFirst());

		System.out.println(ll.removeLast());

		System.out.println(ll.removeFirst());

		//LinkedList实现Queue
		Queue<String> que = new LinkedList<String>();

		System.out.println("\n"+que.offer("AAA"));
		que.offer("SSS");

		System.out.println(que.poll());

		System.out.println(que.peek());
	}
}