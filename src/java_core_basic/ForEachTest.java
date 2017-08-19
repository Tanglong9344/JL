package java_core_basic;

import java.util.ArrayList;
import java.util.List;

public class ForEachTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<5;i++){
			list.add("Hello "+(int)(Math.random()*100));
		}
		list.forEach(s->System.out.println(s));
	}
}
