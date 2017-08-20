package java_lamda_expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * �����н������������ͱ�ʹ�á��⡱�ˣ��޷��ٱ�������������ض����������һ�������� �����������᷵��Stream�����ǻ᷵��int��float��String�� Collection������forEach��ʲô��������,��
 * �����������������б�����Ϊ��ǰ����м����Ҳ�����ʱ�򣬲�������ִ�С�
 * ���������������£�
 * forEach() ����ÿ��Ԫ��
 * toArray() ת��Ϊ����
 * min(Comparator<T>) ȡ��С��Ԫ��
 * max(Comparator<T>) ȡ����Ԫ��
 * count() ����
 * findFirst() ��һ��Ԫ��
 */

public class AggregateEndHandleTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		//forEach() ����ÿ��Ԫ��
		System.out.println("���������е�ÿ������:");
		heros
		.stream()
		.forEach(h->System.out.print(h));
		//toArray() ת��Ϊ����
		System.out.println("����һ������:");
		Object[] hs= heros
				.stream()
				.toArray();
		System.out.println(Arrays.toString(hs));
		//min(Comparator<T>) ȡ��С��Ԫ��
		System.out.println("�����˺���͵��Ǹ�Ӣ��:");
		Hero minDamageHero =
				heros
				.stream()
				.min((h1,h2)->h1.damage-h2.damage)
				.get();
		System.out.print(minDamageHero);
		//max(Comparator<T>) ȡ����Ԫ��
		System.out.println("�����˺���ߵ��Ǹ�Ӣ��:");
		Hero mxnDamageHero =
				heros
				.stream()
				.max((h1,h2)->h1.damage-h2.damage)
				.get();
		System.out.print(mxnDamageHero);
		//count() ����
		System.out.println("�������ݵ�����:");
		long count = heros
				.stream()
				.count();
		System.out.println(count);
		//findFirst() ��һ��Ԫ��
		System.out.println("��һ��Ӣ��:");
		Hero firstHero =
				heros
				.stream()
				.findFirst()
				.get();
		System.out.println(firstHero);
	}
}