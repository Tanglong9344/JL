package java_web_programming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程 网络连接-服务端
 *
 * @author 唐龙
 *
 */
public class MutiThreadServer {
	public static void main(String[] args) throws IOException {
		Socket s = null;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			System.out.println("监听在端口号:8888");
			s = ss.accept();

			//启动发送消息线程
			new SendThread(s).start();
			//启动接受消息线程
			new ReceiveThread(s).start();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ss.close();
			s.close();
		}
	}
}