package java_lamda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 每个中间操作，又会返回一个Stream，比如.filter()又返回一个Stream, 中间操作是“懒”操作，并不会真正进行遍历。
 * 中间操作比较多，主要分两类
 * 对元素进行筛选 和 转换为其他形式的流
 *
 * 对元素进行筛选：
 * filter 匹配
 * distinct 去除重复(根据equals判断)
 * sorted 自然排序
 * sorted(Comparator<T>) 指定排序
 * limit 保留
 * skip 忽略
 *
 * 转换为其他形式的流：
 * mapToDouble 转换为double的流
 * map 转换为任意类型的流
 */

public class AggregateMiddleHandleTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		//制造一个重复数据
		heros.add(heros.get(0));
		System.out.println("初始化集合后的数据 (最后一个数据重复)：");
		System.out.println(heros);
		System.out.println("满足条件hp>100&&damage<50的数据:");
		//filter 匹配
		System.out.println("filter 匹配:");
		heros
		.stream()
		.filter(h->h.hp>100&&h.damage<50)
		.forEach(h->System.out.print(h));
		//去除重复的数据
		System.out.println("去除重复的数据，去除标准是看equals:");
		heros
		.stream()
		.distinct()
		.forEach(h->System.out.print(h));
		//sorted 指定排序
		System.out.println("按照血量排序:");
		heros
		.stream()
		.sorted((h1,h2)->h1.hp>=h2.hp?1:-1)
		.forEach(h->System.out.print(h));
		//limit 保留
		System.out.println("保留3个:");
		heros
		.stream()
		.limit(3)
		.forEach(h->System.out.print(h));
		//skip 忽略
		System.out.println("忽略前3个:");
		heros
		.stream()
		.skip(3)
		.forEach(h->System.out.print(h));
		//mapToDouble 转换为double的流
		System.out.println("转换为double的Stream:");
		heros
		.stream()
		.mapToDouble(Hero::getHp)
		.forEach(h->System.out.println(h));
		//转换任意类型的Stream
		System.out.println("转换任意类型的Stream:");
		heros
		.stream()
		.map((h)-> h.name + " - " + h.hp + " - " + h.damage)
		.forEach(h->System.out.println(h));
	}
}
