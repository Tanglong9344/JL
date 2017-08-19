package java_lamda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ÿ���м�������ֻ᷵��һ��Stream������.filter()�ַ���һ��Stream, �м�����ǡ������������������������б�����
 * �м�����Ƚ϶࣬��Ҫ������
 * ��Ԫ�ؽ���ɸѡ �� ת��Ϊ������ʽ����
 *
 * ��Ԫ�ؽ���ɸѡ��
 * filter ƥ��
 * distinct ȥ���ظ�(����equals�ж�)
 * sorted ��Ȼ����
 * sorted(Comparator<T>) ָ������
 * limit ����
 * skip ����
 *
 * ת��Ϊ������ʽ������
 * mapToDouble ת��Ϊdouble����
 * map ת��Ϊ�������͵���
 */

public class AggregateMiddleHandleTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		//����һ���ظ�����
		heros.add(heros.get(0));
		System.out.println("��ʼ�����Ϻ������ (���һ�������ظ�)��");
		System.out.println(heros);
		System.out.println("��������hp>100&&damage<50������:");
		//filter ƥ��
		System.out.println("filter ƥ��:");
		heros
		.stream()
		.filter(h->h.hp>100&&h.damage<50)
		.forEach(h->System.out.print(h));
		//ȥ���ظ�������
		System.out.println("ȥ���ظ������ݣ�ȥ����׼�ǿ�equals:");
		heros
		.stream()
		.distinct()
		.forEach(h->System.out.print(h));
		//sorted ָ������
		System.out.println("����Ѫ������:");
		heros
		.stream()
		.sorted((h1,h2)->h1.hp>=h2.hp?1:-1)
		.forEach(h->System.out.print(h));
		//limit ����
		System.out.println("����3��:");
		heros
		.stream()
		.limit(3)
		.forEach(h->System.out.print(h));
		//skip ����
		System.out.println("����ǰ3��:");
		heros
		.stream()
		.skip(3)
		.forEach(h->System.out.print(h));
		//mapToDouble ת��Ϊdouble����
		System.out.println("ת��Ϊdouble��Stream:");
		heros
		.stream()
		.mapToDouble(Hero::getHp)
		.forEach(h->System.out.println(h));
		//ת���������͵�Stream
		System.out.println("ת���������͵�Stream:");
		heros
		.stream()
		.map((h)-> h.name + " - " + h.hp + " - " + h.damage)
		.forEach(h->System.out.println(h));
	}
}
