package java_web_programming;
import java.io.IOException;
import java.net.ServerSocket;

public class usrLocalPostScanner {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		// ѭ�����ʶ˿�
		for (int port = 1; port <= 65535; port++) {
			try {
				// �����µķ���˿�
				// ����ڴ˶˿��Ѿ��з�����ڣ����׳��쳣
				ServerSocket server = new ServerSocket(port);
			} catch (IOException e) {
				// ��ӡ���쳣
				System.out.println("There is a server on port " + port + ".");
			}
		}
	}
}