package java_web_programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Local Host information
 *
 * @author ����
 *
 */
public class LocalHost {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress host = InetAddress.getLocalHost();
		System.out.println("��������     ��" + host.getHostName());
		System.out.println("����Ip��ַ��" + host.getHostAddress());
		System.out.println("������·Ip��" + InetAddress.getLoopbackAddress());
		System.out.println("������·Ip��" + InetAddress.getByName(null));
		System.out.println("������·Ip��" + InetAddress.getByName("127.0.0.1"));
	}
}