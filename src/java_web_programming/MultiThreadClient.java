package java_web_programming;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiThreadClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			// 启动发送消息线程
			new SendThread(s).start();
			// 启动接受消息线程
			new ReceiveThread(s).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
