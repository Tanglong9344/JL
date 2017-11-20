package java_collection;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LinkedList
 * 不适合遍历查找
 * 适合插入删除
 * @author 唐龙
 */
public class LinkedListTest {
	public static void main(String[] args) {
		//对象创建
		LinkedList<String> ll = new LinkedList<>();
		System.out.println(ll.toString());
		//在表尾添加
		ll.addLast("AAA");
		System.out.println("addLast:"+ll.toString());
		//在表头添加
		ll.addFirst("BBB");
		System.out.println("addFirst:"+ll.toString());

		//元素获取
		System.out.println("getLast:"+ll.getLast());
		System.out.println("getFirst:"+ll.getFirst());
		//元素删除
		System.out.println("removeLast:"+ll.removeLast());
		System.out.println("removeFirst:"+ll.removeFirst());

		//LinkedList实现Queue
		Queue<String> que = new LinkedList<String>();
		System.out.println("\n添加元素:"+que.offer("AAA"));
		que.offer("SSS");
		System.out.println("删除并返回头元素："+que.poll());
		System.out.println("返回头元素："+que.peek());
	}
}