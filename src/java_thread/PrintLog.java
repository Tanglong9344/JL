package java_thread;

import java_common.CommonMethod;

/**
 * log print
 *
 * @author ����
 *
 */
public class PrintLog {
	//��ӡ��ǰʱ���µ���Ϣ
	public static void log(String msg) {
		System.out.printf("%s %s %s%n", CommonMethod.TIME_NOW, Thread.currentThread().getName(), msg);
	}
}