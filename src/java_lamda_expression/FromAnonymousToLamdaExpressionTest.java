/**
 * From anonymous Class to Lamda expression
 */

package java_lamda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FromAnonymousToLamdaExpressionTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("��ʼ����ļ��ϣ�");
		System.out.println(heros);
		System.out.println("ʹ��������ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
		// �����������д��
		HeroChecker c1 = new HeroChecker() {
			@Override
			public boolean test(Hero h) {
				return (h.hp > 100 && h.damage < 50);
			}
		};
		System.out.println("�����������д��:");
		filter(heros,c1);
		System.out.println("\n");
		// ��new HeroChcekcer������������������������Ϣȥ��
		// ֻ�������������ͷ�����
		// �����ͷ�����֮����Ϸ��� ->
		HeroChecker c2 = (Hero h) -> {
			return h.hp > 100 && h.damage < 50;
		};
		System.out.println("��new HeroChcekcer�������ͷ�������������Ϣȥ��,ֻ�������������ͷ���������ͷ�����֮����Ϸ��� ->:");
		filter(heros,c2);
		System.out.println("\n");
		// ��return��{}ȥ��
		HeroChecker c3 = (Hero h) -> h.hp > 100 && h.damage < 50;
		System.out.println("��return��{}ȥ��:");
		filter(heros,c3);
		System.out.println("\n");
		// �� �������ͺ�Բ����ȥ��
		HeroChecker c4 = h -> h.hp > 100 && h.damage < 50;
		System.out.println("�� �������ͺ�Բ����ȥ��:");
		filter(heros,c4);
		System.out.println("\n");
		// ֱ�Ӱѱ��ʽ���ݽ�ȥ
		System.out.println("ֱ�Ӱѱ��ʽ���ݽ�ȥ:");
		filter(heros, h -> h.hp > 100 && h.damage < 50);
		System.out.println("\n");
	}
	private static void filter(List<Hero> heros, HeroChecker checker) {
		for (Hero hero : heros) {
			if (checker.test(hero))
			System.out.print(hero);
		}
	}
}
