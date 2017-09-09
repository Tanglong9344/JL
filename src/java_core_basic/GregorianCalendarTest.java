package java_core_basic;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {
	public static void main(String[] args) {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		// 创建一个GregorianCalendar日历对象
		GregorianCalendar cal = new GregorianCalendar();
		// 将日历系统的日期和时间设置给cal
		cal.setTime(new Date());
		System.out.println("GregorianCalendar类的日期: "+ dateFormat.format(cal.getTime()));
		System.out.println("时间计数开始日期为: " + dateFormat.format(cal.getFirstDayOfWeek()));
	}
}