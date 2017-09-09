package java_core_basic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		//时间格式化
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf3 = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();
		System.out.println("日期:"+date);
		System.out.println("日期格式化1:"+sf1.format(date));
		System.out.println("日期格式化2:"+sf2.format(date));
		System.out.println("日期格式化3:"+sf3.format(date));
		System.out.println("调用 System.currentTimeMillis()："+System.currentTimeMillis());

		//getTime()
		System.out.println("getTime():"+date.getTime());
	}
}
