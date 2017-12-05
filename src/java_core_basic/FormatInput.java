package java_core_basic;

import java.util.Locale;

/**
 * 格式化输出
 * @author 唐龙
 */
public class FormatInput {
	public static void main(String[] args) {
		String name = "盖伦";
		int kill = 8;
		String title = "超神";
		System.out.printf("Hello 盖伦，努力吧！%n");// %n换行符，与平台无关
		String sentenceFormat = "%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
		// 使用printf格式化输出
		System.out.printf(sentenceFormat, name, kill, title);// print()直接调用format()
		// 使用format格式化输出
		System.out.format(sentenceFormat, name, kill, title);
		int year = 2020;
		// 总长度，左对齐，补0，千位分隔符，小数点位数，本地化表达
		// 直接打印数字
		System.out.format("%d%n", year);
		// 总长度是8,默认右对齐
		System.out.format("%8d%n", year);
		// 总长度是8,左对齐
		System.out.format("%-8d%n", year);
		// 总长度是8,不够补0
		System.out.format("%08d%n", year);
		// 千位分隔符
		System.out.format("%,8d%n", year * 10000);
		// 小数点位数
		System.out.format("%.5f%n", Math.PI);
		// 不同国家的千位分隔符
		System.out.format(Locale.FRANCE, "%,.2f%n", Math.PI * 10000);
		System.out.format(Locale.US, "%,.2f%n", Math.PI * 10000);
		System.out.format(Locale.UK, "%,.2f%n", Math.PI * 10000);
	}
}