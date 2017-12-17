package java_lamda_expression;

import static java_lamda_expression.CommonConstant.N;
import static java_lamda_expression.CommonConstant.RANGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Lambda Filter
 *
 * @author 唐龙
 */
public class Lambda{
	public static void main(String[] args) {
		Random r = new Random();
		List<String> strs = new ArrayList<String>();
		//初始化
		for (int i = 1; i <= N; i++) {
			strs.add("String" + r.nextInt(RANGE));
		}
		System.out.println("初始化后的集合:\n" + strs);
		System.out.println("使用Lamdba的方式，筛选出最后一个字符为偶数的字符串:");
		Checker.filter(strs,new Checker());
	}
}