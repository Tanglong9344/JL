package java_rxjava2;

import java.util.Iterator;
import java.util.List;

public class HelloRxJava {
	public static void main(String[] args) {
		// Iterator
		List<String> list = java_common.CommonUtils.getList(10);
		for(Iterator<String> i=list.iterator();i.hasNext();) {
			System.out.print(i.next() + ", ");
		}
	}
}