package java_common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Common methods
 *
 * @author ÌÆÁú
 */
public class CommonMethod {
	/**get current time in the form of "yyyy-MM-dd HH:mm:ss"*/
	public static final String TIME_NOW = getTimeNow();
	private static String getTimeNow(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	/**get current time in the form of nanosecond*/
	public static long nano() {
		return System.nanoTime();
	}

	/**get current time in the form of millisecond*/
	public static long milli() {
		return System.currentTimeMillis();
	}
}