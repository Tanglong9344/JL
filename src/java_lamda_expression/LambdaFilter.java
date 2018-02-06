package java_lamda_expression;

import static java_common.CommonValue.N;

import java.util.List;

/**
 * Lambda Filter
 *
 * @author 唐龙
 */
public class LambdaFilter{
	public static void main(String[] args) {
		List<String> strs = java_common.CommonUtils.getList(N);
		System.out.println("初始化后的集合:\n" + strs);
		System.out.println("使用Lamdba的方式，筛选出最后一个字符为偶数的字符串:");
		Checker.filter(strs,new Checker());
	}
}