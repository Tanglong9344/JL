package java_core_basic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Date��
 * @author ����
 */
public class DateTest {
	public static void main(String[] args) {
		//ʱ���ʽ��
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sf3 = new SimpleDateFormat("MM/dd/yyyy");

		Date date = new Date();
		//��ǰ����
		System.out.println("��ǰ����:"+date);
		//������
		System.out.println("���ڸ�ʽ��(yyyy-MM-dd):"+sf1.format(date));
		//������ ʱ����
		System.out.println("���ڸ�ʽ��(yyyy-MM-dd HH:mm:ss):"+sf2.format(date));
		//������
		System.out.println("���ڸ�ʽ��(MM/dd/yyyy):"+sf3.format(date));
		// System.currentTimeMillis()
		System.out.println("System.currentTimeMillis():"+System.currentTimeMillis());
		//getTime()
		System.out.println("getTime():"+date.getTime());

		//���ڵ� after()����
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE,-1);//��������ǰ����һ��
		Date dateBefore = calendar.getTime();
		System.out.println("---------------------------------");
		System.out.print(sf1.format(date)+" �� ");
		System.out.print(sf1.format(dateBefore)+" ֮��");
		System.out.println(date.after(dateBefore));
		System.out.println("---------------------------------");

		//���ڵ� before()����
		calendar.setTime(date);
		calendar.add(Calendar.DATE,1);//��������������һ��
		Date dateAfter = calendar.getTime();
		System.out.println("---------------------------------");
		System.out.print(sf1.format(date)+" �� ");
		System.out.print(sf1.format(dateAfter)+" ֮ǰ��");
		System.out.println(date.before(dateAfter));
		System.out.println("---------------------------------");
	}
}
