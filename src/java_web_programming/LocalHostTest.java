package java_web_programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHostTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress host = InetAddress.getLocalHost();
		System.out.println("�������ƣ�" + host.getHostName());
		System.out.println("����Ip��ַ��" + host.getHostAddress());
		System.out.println("������·Ip��"+InetAddress.getLoopbackAddress());
		System.out.println("������·Ip��"+InetAddress.getByName(null));
		System.out.println("������·Ip��"+InetAddress.getByName("127.0.0.1"));
	}
}
