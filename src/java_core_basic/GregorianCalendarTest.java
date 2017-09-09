package java_core_basic;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {
	public static void main(String[] args) {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		// ����һ��GregorianCalendar��������
		GregorianCalendar cal = new GregorianCalendar();
		// ������ϵͳ�����ں�ʱ�����ø�cal
		cal.setTime(new Date());
		System.out.println("GregorianCalendar�������: "+ dateFormat.format(cal.getTime()));
		System.out.println("ʱ�������ʼ����Ϊ: " + dateFormat.format(cal.getFirstDayOfWeek()));
	}
}