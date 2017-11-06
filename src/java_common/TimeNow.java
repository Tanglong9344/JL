/**
 * 获取系统当前时间
 * 以yyyy-MM-dd HH:mm:ss格式返回
 */

package java_common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeNow {
	public static String getTimeNow(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}