package java_lamda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LamdaTest {
	static final int N = 5;
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		//��ʼ��
		for (int i = 0; i < N; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("��ʼ����ļ��ϣ�");
		System.out.println(heros);
		System.out.println("ʹ��Lamdba�ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
		filter(heros,h->h.hp>100 && h.damage<50);
	}
	private static void filter(List<Hero> heros,HeroChecker checker) {
		for (Hero hero : heros) {
			if(checker.test(hero)) {
				System.out.print(hero);
			}
		}
	}
}