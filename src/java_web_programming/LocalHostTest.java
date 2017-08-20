package java_web_programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHostTest {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws UnknownHostException {
		InetAddress host = InetAddress.getLocalHost();
		String ip =host.getHostAddress();
		String name = host.getHostName();
		System.out.println("本机名称：" + name);
		System.out.println("本机Ip地址：" + ip);
		System.out.println("本机固定Ip："+host.getLoopbackAddress());
	}
}
