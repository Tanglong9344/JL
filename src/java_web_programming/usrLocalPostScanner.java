package java_web_programming;
import java.io.IOException;
import java.net.ServerSocket;

public class usrLocalPostScanner {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		// 循环访问端口
		for (int port = 1; port <= 65535; port++) {
			try {
				// 建立新的服务端口
				// 如果在此端口已经有服务存在，则抛出异常
				ServerSocket server = new ServerSocket(port);
			} catch (IOException e) {
				// 打印出异常
				System.out.println("There is a server on port " + port + ".");
			}
		}
	}
}