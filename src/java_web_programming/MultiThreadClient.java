package java_web_programming;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiThreadClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			// ����������Ϣ�߳�
			new SendThread(s).start();
			// ����������Ϣ�߳�
			new ReceiveThread(s).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
