package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	/**
	 * ��ȡ���ں�ʱ��
	 * @return
	 */
	public static String getDateTime() {
		Date dt = new Date();
		long tm = dt.getTime();
		return ((new java.sql.Date(tm)) + " " + (new java.sql.Time(tm)));
	}

	/**
	 * ��ȡ����
	 * @return
	 */
	public static String getDate() {
		Date dt = new Date();
		long tm = dt.getTime();
		return (new java.sql.Date(tm)).toString();
	}

	/**
	 * �õ���ǰ����ǰ���������
	 * @return yyyy-mm-dd
	 */
	public static String getBeforeDay(int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE,-num);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		return sdf.format(calendar.getTime());
	}

	/**
	 * �õ��������ں��յ�����
	 * @param num
	 * @return
	 */
	public static String getAfterDay(String date, int num) {
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date a = null;
		try {
			a = parser.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(a);
		calendar.add(Calendar.DATE, num);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		return sdf.format(calendar.getTime());
	}

	/**
	 * �����ַ����õ������͵�����
	 * @param day
	 * @return date
	 */
	public static Date getStringToDate(String day) {
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date a = new Date();
		try {
			a = parser.parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return a;
	}
}