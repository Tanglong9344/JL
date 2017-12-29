package java_web_programming;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * print all the ports that are used
 *
 * @author 唐龙
 *
 */
public class usrLocalPostScanner {
	public static void main(String[] args) throws IOException {
		// 循环访问端口
		ServerSocket server = null;
		for (int port = 1; port <= 65535; port++) {
			try {
				// 建立新的服务端口
				// 如果在此端口已经有服务存在，则抛出异常
				server = new ServerSocket(port);
			} catch (IOException e) {
				// 打印出异常
				System.out.println("There is a server on port " + port + ".");
			}
		}
		server.close();
	}
}