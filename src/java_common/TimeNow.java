package java_common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��ȡϵͳ��ǰʱ��
 * ��yyyy-MM-dd HH:mm:ss��ʽ����
 * @author ����
 */
public class TimeNow {
	public static final String TIME_NOW = getTimeNow();
	private static String getTimeNow(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}