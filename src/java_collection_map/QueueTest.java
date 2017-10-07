package java_collection_map;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列(First-In-First-Out)
 */

public class QueueTest {
	public static void main(String[] args) {
		final int N = 5;
		final int RANGE = 10;
		//ArrayDeque
		Queue<String> queue = new ArrayDeque<String>();
		for(int i=0;i<N;i++){
			queue.offer(String.valueOf((int)(Math.random()*RANGE)));
			queue.add(String.valueOf((int)(Math.random()*RANGE)));
		}
		System.out.println("------ArrayDeque Init---------");
		System.out.println("queue=" + queue);

		//remove
		//获取并移除元素
		System.out.println("-----------remove------------");
		System.out.println(queue.remove());
		System.out.println("queue=" + queue);

		//poll
		//获取并移除元素
		System.out.println("-----------poll--------------");
		System.out.println(queue.poll());
		System.out.println("queue=" + queue);

		//peek
		//获取但不移除元素
		System.out.println("-----------peek--------------");
		System.out.println(queue.peek());
		System.out.println("queue=" + queue);

		//element
		//获取但不移除元素
		System.out.println("-----------element-----------");
		System.out.println(queue.element());
		System.out.println("queue=" + queue);

		//LinkedList
		queue = new LinkedList<String>();
		for(int i=0;i<N;i++){
			queue.offer(String.valueOf((int)(Math.random()*RANGE)));
			queue.add(String.valueOf((int)(Math.random()*RANGE)));
		}
		System.out.println("------LinkedList Init--------");
		System.out.println("queue=" + queue);
	}
}