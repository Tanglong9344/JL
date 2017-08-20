/**
 * Ҫ�˽�ۺϲ���������Ҫ����Stream�͹ܵ��ĸ���
 * Stream ��Collection�ṹ�������ݲ�һ����
 * Stream��һϵ�е�Ԫ�أ��������������ϵĹ�ͷһ����һ�����ĳ�����
 *
 * �ܵ�ָ����һϵ�еľۺϲ�����
 * �ܵ��ַ�3������
 * �ܵ�Դ������������Դ��һ��List
 * �м������ ÿ���м�������ֻ᷵��һ��Stream��
 * ����.filter()�ַ���һ��Stream, �м�����ǡ������������������������б�����
 * �������������������ִ�к����ͱ�ʹ�á��⡱�ˣ��޷��ٱ�������������ض����������һ��������
 * �����������᷵��Stream�����ǻ᷵��int��float��String�� Collection
 * ������forEach��ʲô��������, ���������Ž��������ı�����Ϊ���ڱ�����ʱ�򣬲Ż�ȥ�����м����������ж�
 *
 * ע�� ���Stream��I/O�½ڵ�InputStream,OutputStream�ǲ�һ���ĸ��
 */

package java_lamda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AggregateTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("��ʼ����ļ��ϣ�");
		System.out.println(heros);

		System.out.println("ͨ����ͳ������ʽ�ҳ��������������ݣ�");
		for (Hero h : heros) {
			if (h.hp > 100 && h.damage < 50)
				System.out.println(h.name);
		}
		System.out.println("ͨ���ۺϲ�����ʽ�ҳ��������������ݣ�");
		//�ۺϲ���
		heros
		.stream()
		.filter(h -> h.hp > 100 && h.damage < 50)
		.forEach(h -> System.out.println(h.name));
	}
}
