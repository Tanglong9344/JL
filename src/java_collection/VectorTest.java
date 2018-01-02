package java_collection;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Java Vector
 *
 * @author 唐龙
 */
public class VectorTest {
	public static void main(String[] args) {
		// 创建一个Vector对象,容量初始化为5
		Vector<String> vec = new Vector<String>(5);
		// 添加元素
		vec.addElement(new String("one"));
		vec.addElement("three");
		//插入元素
		vec.insertElementAt("zero", 0);
		vec.insertElementAt("two", 2);
		//数值
		System.out.println("vec:" + vec);
		//容量
		System.out.println("vec的容量为:" + vec.capacity());

		// 创建一个Vector对象,容量初始化为5,容量的增量为1
		Vector<String> vector = new Vector<String>(5,1);
		vector.addElement("one");
		vector.addElement(new String("three"));
		vector.insertElementAt("zero", 0);
		vector.insertElementAt("two", 2);
		System.out.println("vector:" + vector);
		System.out.println("vector的容量为：" + vector.capacity());


		// tranverse-1
		System.out.println("\n---------tranverse-1------------\n");
		for(int i=0,len=vector.size();i<len;i++) {
			System.out.print(vector.elementAt(i) + " ");
		}

		// tranverse-2
		System.out.println("\n---------tranverse-2------------\n");
		for(Enumeration<String> e=vector.elements();e.hasMoreElements();) {
			System.out.print(e.nextElement() + " ");
		}
	}
}