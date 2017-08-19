package java_lamda_expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 当进行结束操作后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。 结束操作不会返回Stream，但是会返回int、float、String、 Collection或者像forEach，什么都不返回,。
 * 结束操作才真正进行遍历行为，前面的中间操作也在这个时候，才真正的执行。
 * 常见结束操作如下：
 * forEach() 遍历每个元素
 * toArray() 转换为数组
 * min(Comparator<T>) 取最小的元素
 * max(Comparator<T>) 取最大的元素
 * count() 总数
 * findFirst() 第一个元素
 */

public class AggregateEndHandleTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		//forEach() 遍历每个元素
		System.out.println("遍历集合中的每个数据:");
		heros
		.stream()
		.forEach(h->System.out.print(h));
		//toArray() 转换为数组
		System.out.println("返回一个数组:");
		Object[] hs= heros
				.stream()
				.toArray();
		System.out.println(Arrays.toString(hs));
		//min(Comparator<T>) 取最小的元素
		System.out.println("返回伤害最低的那个英雄:");
		Hero minDamageHero =
				heros
				.stream()
				.min((h1,h2)->h1.damage-h2.damage)
				.get();
		System.out.print(minDamageHero);
		//max(Comparator<T>) 取最大的元素
		System.out.println("返回伤害最高的那个英雄:");
		Hero mxnDamageHero =
				heros
				.stream()
				.max((h1,h2)->h1.damage-h2.damage)
				.get();
		System.out.print(mxnDamageHero);
		//count() 总数
		System.out.println("流中数据的总数:");
		long count = heros
				.stream()
				.count();
		System.out.println(count);
		//findFirst() 第一个元素
		System.out.println("第一个英雄:");
		Hero firstHero =
				heros
				.stream()
				.findFirst()
				.get();
		System.out.println(firstHero);
	}
}