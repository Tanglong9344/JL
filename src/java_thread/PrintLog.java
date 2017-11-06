package java_thread;

import java_common.TimeNow;

public class PrintLog {
	//打印当前时间下的信息
	public static void log(String msg) {
		System.out.printf("%s %s %s%n", TimeNow.getTimeNow(), Thread.currentThread().getName(), msg);
	}
}
