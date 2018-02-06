package java_lamda_expression;

import static java_lamda_expression.CommonConstant.N;

import java.util.List;

/**聚合操作-中间操作
 *
 * 每个中间操作，又会返回一个Stream，
 * 比如.filter()又返回一个Stream,
 * 中间操作是“懒”操作，并不会真正进行遍历。
 * 中间操作比较多，主要分两类
 * 1.对元素进行筛选：
 * 1.1 filter 匹配
 * 1.2 distinct 去除重复(根据equals判断)
 * 1.3 sorted 自然排序
 * 1.4 sorted(Comparator<T>) 指定排序
 * 1.5 limit 保留
 * 1.6 skip 忽略
 *
 * 2.转换为其他形式的流：
 * 2.1 mapToDouble 转换为double的流
 * 2.2 map 转换为任意类型的流
 *
 * @author 唐龙
 */
public class AggregateMiddleHandle {
	public static void main(String[] args) {
		List<String> strs = java_common.CommonUtils.getList(N);
		System.out.println("初始化后的集合:\n" + strs);

		//制造一个重复数据
		strs.add(strs.get(strs.size()-1));
		System.out.println("初始化集合后的数据 (最后一个数据重复):\n" + strs);

		//filter 匹配
		System.out.println("满足最后一个字符为偶数的数据, filter 匹配: ");
		strs
		.stream()
		.filter(s->(s.charAt(s.length()-1))%2 == 0)
		.forEach(s->System.out.println(s));

		//去除重复的数据
		System.out.println("去除重复的数据，去除标准是看equals:");
		strs
		.stream()
		.distinct()
		.forEach(s->System.out.println(s));

		//sorted 指定排序
		System.out.println("排序:");
		strs
		.stream()
		.sorted((s1,s2)->s1.compareTo(s2))
		.forEach(s->System.out.println(s));

		//limit 保留
		System.out.println("保留3个:");
		strs
		.stream()
		.limit(3)
		.forEach(s->System.out.println(s));

		//skip 忽略
		System.out.println("忽略前3个:");
		strs
		.stream()
		.skip(3)
		.forEach(s->System.out.println(s));

		//转换任意类型的Stream
		System.out.println("转换任意类型的Stream:");
		strs
		.stream()
		.map((s)->s + ", After mapping...")
		.forEach(s->System.out.println(s));
	}
}