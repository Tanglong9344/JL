package java_thread;

import java_common.TimeNow;

public class PrintLog {
	//��ӡ��ǰʱ���µ���Ϣ
	public static void log(String msg) {
		System.out.printf("%s %s %s%n", TimeNow.getTimeNow(), Thread.currentThread().getName(), msg);
	}
}
