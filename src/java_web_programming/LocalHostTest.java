package java_web_programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHostTest {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws UnknownHostException {
		InetAddress host = InetAddress.getLocalHost();
		String ip =host.getHostAddress();
		String name = host.getHostName();
		System.out.println("�������ƣ�" + name);
		System.out.println("����Ip��ַ��" + ip);
		System.out.println("�����̶�Ip��"+host.getLoopbackAddress());
	}
}
