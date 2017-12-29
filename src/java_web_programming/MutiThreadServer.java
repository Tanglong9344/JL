package java_web_programming;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���߳� ��������-�����
 *
 * @author ����
 *
 */
public class MutiThreadServer {
	public static void main(String[] args) throws IOException {
		Socket s = null;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			System.out.println("�����ڶ˿ں�:8888");
			s = ss.accept();

			//����������Ϣ�߳�
			new SendThread(s).start();
			//����������Ϣ�߳�
			new ReceiveThread(s).start();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ss.close();
			s.close();
		}
	}
}