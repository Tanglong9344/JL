package java_lamda_expression;

import static java_common.CommonValue.N;

import java.util.Arrays;
import java.util.List;

/**
 * 聚合操作-管道源
 *
 * @author 唐龙
 */
public class AggregateStream {
	public static void main(String[] args) {
		List<String> strList = java_common.CommonUtils.getList(N);
		System.out.println("初始化后的集合:\n" + strList);
		//管道源是集合
		System.out.println("管道源是集合:");
		strList
		.stream()
		.forEach(s->System.out.println(s));

		//管道源是数组
		System.out.println("管道源是数组:");
		String strArr[] = strList.toArray(new String[strList.size()]);
		Arrays
		.stream(strArr)
		.forEach(s->System.out.println(s));
	}
}