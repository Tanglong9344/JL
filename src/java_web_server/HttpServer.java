package java_web_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Java Web ������
 *
 * @author ����
 *
 */
public class HttpServer {
	/** ָ��HTML�������ļ���ŵ�Ŀ¼  */
	public static final String WEB_ROOT = "src/java_web_server";

	public static void main(String[] args) {
		System.out.println(WEB_ROOT);
		HttpServer server = new HttpServer();
		// �ȴ���������
		server.await();
	}

	/** �ȴ�����  */
	@SuppressWarnings("resource")
	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		String ip = "127.0.0.1";
		try {
			//�������׽��ֶ���
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName(ip));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		System.out.println("Listening...");
		// ѭ���ȴ�һ������
		while (true) {
			Socket socket   = null;
			InputStream is  = null;
			OutputStream os = null;
			try {
				//�ȴ����ӣ����ӳɹ��󣬷���һ��Socket����
				socket = serverSocket.accept();
				is     = socket.getInputStream();
				os     = socket.getOutputStream();
				// ����Request���󲢽���
				Request request = new Request(is);
				request.parse();

				// ���� Response ����
				Response response = new Response(os);
				response.setRequest(request);
				response.sendStaticResource();
				// �ر� socket ����
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}