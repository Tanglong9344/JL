package java_web_programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Local Host information
 *
 * @author 唐龙
 *
 */
public class LocalHost {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress host = InetAddress.getLocalHost();
		System.out.println("本机名称     ：" + host.getHostName());
		System.out.println("本机Ip地址：" + host.getHostAddress());
		System.out.println("本机回路Ip：" + InetAddress.getLoopbackAddress());
		System.out.println("本机回路Ip：" + InetAddress.getByName(null));
		System.out.println("本机回路Ip：" + InetAddress.getByName("127.0.0.1"));
	}
}