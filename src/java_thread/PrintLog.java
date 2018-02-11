package java_thread;

import java_common.CommonMethod;

/**
 * log print
 *
 * @author 唐龙
 *
 */
public class PrintLog {
	//打印当前时间下的信息
	public static void log(String msg) {
		System.out.printf("%s %s %s%n", CommonMethod.TIME_NOW, Thread.currentThread().getName(), msg);
	}
}