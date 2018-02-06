package java_lamda_expression;

import static java_common.CommonValue.N;

import java.util.List;

/**
 * 聚合操作
 * 1. Stream和Collection结构化的数据不一样，Stream是一系列的元素，如同水流一样连绵不绝。
 * 2. 管道指的是一系列的聚合操作。
 * 2.1 管道源：在这个例子里，源是一个List
 * 2.2 中间操作： 每个中间操作，又会返回一个Stream，
 *     比如.filter()又返回一个Stream, 中间操作是“懒”操作，并不会真正进行遍历。
 * 2.3 结束操作：当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。
 *     结束操作不会返回Stream，但是会返回int、float、String、 Collection
 *     或者像forEach，什么都不返回, 结束操作才进行真正的遍历行为，在遍历的时候，才会去进行中间操作的相关判断
 *
 * 注： 这个Stream和I/O章节的InputStream,OutputStream是不一样的概念。
 *
 * @author 唐龙
 */
public class AggregateOperation {
	public static void main(String[] args) {
		List<String> strs = java_common.CommonUtils.getList(N);
		System.out.println("初始化后的集合:\n" + strs);

		System.out.println("通过传统操作方式找出满足条件的数据：");
		for (String str : strs) {
			if ((str.charAt(str.length()-1))%2 == 0) {
				System.out.println(str);
			}
		}
		System.out.println("通过聚合操作方式找出满足条件的数据：");
		//聚合操作
		strs
		.stream()
		.filter(s -> (s.charAt(s.length()-1))%2 == 0)
		.forEach(s -> System.out.println(s));
	}
}