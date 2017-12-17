package java_lamda_expression;

import static java_lamda_expression.CommonConstant.N;
import static java_lamda_expression.CommonConstant.RANGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 聚合操作-管道源
 *
 * @author 唐龙
 */
public class AggregateStream {
	public static void main(String[] args) {
		Random r = new Random();
		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			strList.add("String" + r.nextInt(RANGE));
		}
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