package java_core_basic;

import java.util.Date;
import java.util.Formatter;

/**
 * Formatter类格式化显示
 * @author 唐龙
 */
public class FormatterTest {
	public static void main(String[] args) {
		Formatter fmt = new Formatter(System.out);
		Date date = new Date();
		fmt.format("当前系统显示的时间和日期为：%tc\n", date);
		fmt.format("当前的日期为[中国格式的日期]：%tF\n", date);
		fmt.format("当前的日期为[美国格式的日期]：%tD\n", date);
		fmt.format("今天是星期几？：%tA\n", date);
		fmt.format("现在时间为[24小时制]：%tT\n", date);
		fmt.format("现在时间为[12小时制]：%tR\n", date);
		fmt.format("现在是几月份：%tB\n", date);
		fmt.format("今天是几号：%te号\n", date);
		fmt.close();
	}
}