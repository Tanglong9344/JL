package java_core_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	static final int N = 10;
	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>(N);
		//��ʼ������
		for(int i=0;i<N;i++){
			strs.add(String.valueOf(Math.floor(Math.random()*100)));
		}
		//����ǰ
		System.out.println("����ǰ:");
		for(String str : strs){
			System.out.println(str);
		}
		//ʹ�ñȽ�������
		Collections.sort(strs,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		//�����
		System.out.println("�����:");
		for(String str : strs){
			System.out.println(str);
		}
	}
}