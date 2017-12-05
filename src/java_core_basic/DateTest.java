package java_core_basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Date类
 * @author 唐龙
 */
public class DateTest {
	public static void main(String[] args) {
		//时间格式化
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf3 = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();
		//当前日期
		System.out.println("当前日期:"+date);
		//年月日
		System.out.println("日期格式化(yyyy-MM-dd):"+sf1.format(date));
		//年月日 时分秒
		System.out.println("日期格式化(yyyy-MM-dd HH:mm:ss):"+sf2.format(date));
		//月日年
		System.out.println("日期格式化(MM/dd/yyyy):"+sf3.format(date));
		// System.currentTimeMillis()
		System.out.println("System.currentTimeMillis():"+System.currentTimeMillis());
		//getTime()
		System.out.println("getTime():"+date.getTime());

		//日期的 after()方法
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE,-1);//把日期往前减少一天
		Date dateBefore = calendar.getTime();
		System.out.println("---------------------------------");
		System.out.print(sf1.format(date)+" 在 ");
		System.out.print(sf1.format(dateBefore)+" 之后：");
		System.out.println(date.after(dateBefore));
		System.out.println("---------------------------------");

		//日期的 before()方法
		calendar.setTime(date);
		calendar.add(Calendar.DATE,1);//把日期往后增加一天
		Date dateAfter = calendar.getTime();
		System.out.println("---------------------------------");
		System.out.print(sf1.format(date)+" 在 ");
		System.out.print(sf1.format(dateAfter)+" 之前：");
		System.out.println(date.before(dateAfter));
		System.out.println("---------------------------------");
	}
}
