package java_collection;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Java Vector
 *
 * @author ����
 */
public class VectorTest {
	public static void main(String[] args) {
		// ����һ��Vector����,������ʼ��Ϊ5
		Vector<String> vec = new Vector<String>(5);
		// ���Ԫ��
		vec.addElement(new String("one"));
		vec.addElement("three");
		//����Ԫ��
		vec.insertElementAt("zero", 0);
		vec.insertElementAt("two", 2);
		//��ֵ
		System.out.println("vec:" + vec);
		//����
		System.out.println("vec������Ϊ:" + vec.capacity());

		// ����һ��Vector����,������ʼ��Ϊ5,����������Ϊ1
		Vector<String> vector = new Vector<String>(5,1);
		vector.addElement("one");
		vector.addElement(new String("three"));
		vector.insertElementAt("zero", 0);
		vector.insertElementAt("two", 2);
		System.out.println("vector:" + vector);
		System.out.println("vector������Ϊ��" + vector.capacity());


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