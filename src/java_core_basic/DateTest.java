package java_core_basic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		//ʱ���ʽ��
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf3 = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();
		System.out.println("����:"+date);
		System.out.println("���ڸ�ʽ��1:"+sf1.format(date));
		System.out.println("���ڸ�ʽ��2:"+sf2.format(date));
		System.out.println("���ڸ�ʽ��3:"+sf3.format(date));
		System.out.println("���� System.currentTimeMillis()��"+System.currentTimeMillis());

		//getTime()
		System.out.println("getTime():"+date.getTime());
	}
}
