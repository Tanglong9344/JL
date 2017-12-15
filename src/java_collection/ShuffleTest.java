package java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections.shuffle()
 * @author ����
 */
public class ShuffleTest {
	public static void main(String[] args) {
		//��ʼ������numbers
		List<Integer> numbers = new ArrayList<>();
		final int NUM = 10000;
		//���ϳ�ʼ��
		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}
		int times = 0;
		//��������
		for(int i=0;i<NUM;i++){
			Collections.shuffle(numbers);
			if(numbers.get(0) == 3
					&& numbers.get(1) == 1
					&& numbers.get(2) == 4){
				times += 1;
			}
		}
		float rate = (float)times/NUM;
		System.out.println("����:"+ rate);
	}
}
