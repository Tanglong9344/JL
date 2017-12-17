package java_lamda_expression;

import static java_lamda_expression.CommonConstant.RANGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 聚合操作-结束操作
 * 1. 当进行结束操作后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。
 *    结束操作不会返回Stream，但是会返回int、float、String、 Collection
 *    或者像forEach，什么都不返回。
 * 2. 结束操作才真正进行遍历行为，前面的中间操作也在这个时候，才真正的执行。
 * 3. 常见结束操作如下：
 *    3.1 forEach() 遍历每个元素
 *    3.2 toArray() 转换为数组
 *    3.3 min(Comparator<T>) 取最小的元素
 *    3.4 max(Comparator<T>) 取最大的元素
 *    3.5 count() 总数
 *    3.6 findFirst() 第一个元素
 *
 * @author 唐龙
 */
public class AggregateEndHandle {
	static final int N = 5;
	public static void main(String[] args) {
		Random r = new Random();
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			strs.add("String" + r.nextInt(RANGE));
		}
		System.out.println("初始化后的集合:\n" + strs);

		//forEach() 遍历每个元素
		System.out.println("遍历集合中的每个数据:");
		strs
		.stream()
		.forEach(s->System.out.println(s));

		//toArray() 转换为数组
		System.out.println("返回一个数组:");
		Object[] arr= strs
				.stream()
				.toArray();
		System.out.println(Arrays.toString(arr));

		//min(Comparator<T>) 取最小的元素
		System.out.print("返回最小元素: ");
		String min = strs
				.stream()
				.min((s1,s2)->s1.compareTo(s2))
				.get();
		System.out.println(min);

		//max(Comparator<T>) 取最大的元素
		System.out.print("返回最大元素: ");
		String max = strs
				.stream()
				.max((s1,s2)->s1.compareTo(s2))
				.get();
		System.out.println(max);

		//count() 总数
		System.out.print("流中数据的总数: ");
		long count = strs
				.stream()
				.count();
		System.out.println(count);

		//findFirst() 第一个元素
		System.out.print("第一个元素: ");
		String first = strs
				.stream()
				.findFirst()
				.get();
		System.out.println(first);
	}
}