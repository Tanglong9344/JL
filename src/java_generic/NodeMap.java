package java_generic;

import java.util.function.Function;

/**
 * Node Map and Travers
 *
 * @author ÌÆÁú
 *
 */
public class NodeMap {
	public static void main(String[] args) {
		// Map Function
		Function<Integer, Integer> f = (Integer x)->(2*x);
		// Node
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> node1 = new Node<Integer>(2);
		head.next = node1;
		Node<Integer> node2 = new Node<Integer>(3);
		node1.next = node2;

		System.out.println("------Before Changed------");
		view(head);

		Node<Integer> h = map(head,f);
		System.out.println("------After Changed------");
		view(h);
	}

	/**Node Map*/
	static <T, R> Node<R> map(Node<T> head, Function<T, R> f) {
		if(head == null){
			return null;
		}
		@SuppressWarnings("unchecked")
		Node<R> data = new Node<R>(f.apply((T) head.data));
		Node<R> h =data;
		while(head.next != null){
			head = head.next;
			@SuppressWarnings("unchecked")
			Node<R> data2 = new Node<R>(f.apply((T) head.data));
			data.next = data2;
			data=data2;
		}
		return h;
	}

	/**Travers Nodes*/
	static void view(Node<?> node){
		if(node == null){
			return;
		}
		System.out.println(node.data);
		while(node.next != null){
			node = node.next;
			System.out.println(node.data);
		}
	}
}

/**Node*/
class Node<T> {
	public Object data;
	public Node<T> next;

	Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	Node(T data) {
		this(data, null);
	}
}