package java_lamda_expression;
import java.util.ArrayList;
import java.util.Random;

public class AnonymousClassTest {
	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);
		System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");
		HeroChecker checker = new HeroChecker() {
			@Override
			public boolean test(Hero h) {
				return (h.hp>100 && h.damage<50);
			}
		};
		filter(heros,checker);
		}
		private static void filter(ArrayList<Hero> heros,HeroChecker checker) {
		for (Hero hero : heros) {
			if(checker.test(hero))
				System.out.print(hero);
		}
	}
}
