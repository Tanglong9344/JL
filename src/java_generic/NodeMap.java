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
		// Initialize Node
		Node<Integer> head = new Node<Integer>(1);//Head Node
		Node<Integer> node = head;
		for(int i=2;i<=10;i++){
			node.next = new Node<Integer>(i);
			node = node.next;
		}
		System.out.println("\n------Before Changed------");
		view(head);

		// Map Node
		System.out.println("\n------After Changed------");
		Node<Integer> h = map(head,f);
		view(h);
	}

	/**Node Map*/
	@SuppressWarnings("unchecked")
	static <T, R> Node<R> map(Node<T> head, Function<T, R> f) {
		if(head == null){
			return null;
		}
		Node<R> node = new Node<R>(f.apply((T) head.data));
		Node<R> h = node;
		while((head=head.next) != null){
			node.next = new Node<R>(f.apply((T) head.data));
			node = node.next;
		}
		return h;
	}

	/**Traverse Nodes*/
	static void view(Node<?> node){
		while(node != null){
			System.out.print(node.data);
			node = node.next;
			if(node != null) {
				System.out.print("->");
			}
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